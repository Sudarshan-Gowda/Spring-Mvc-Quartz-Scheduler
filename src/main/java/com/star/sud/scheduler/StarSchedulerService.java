package com.star.sud.scheduler;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import com.star.sud.framework.model.ApplicationScheduler;
import com.star.sud.framework.model.SchedulerJobs;
import com.star.sud.framework.service.StarUtilService;
import com.star.sud.framework.service.email.EmailInfo;
import com.star.sud.framework.service.email.EmailService;

@Service("starSchedulerService")
public class StarSchedulerService {

	@Resource(name = "starUtilService")
	protected StarUtilService starUtilService;

	@Resource(name = "starEmailInfo")
	protected EmailInfo defEmailInfo;

	@Resource(name = "starEmailService")
	protected EmailService emailService;

	public Scheduler createScheduler() {

		Scheduler sch = null;
		try {
			sch = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sch;
	}

	public Boolean startScheduler(Scheduler schedulerObj, ApplicationScheduler appScheduler) {

		Boolean isStarted = Boolean.FALSE;
		List<JobDetail> jobArr = new ArrayList<JobDetail>();

		List<SimpleTrigger> triggerArr = new ArrayList<SimpleTrigger>();
		for (SchedulerJobs schJob : appScheduler.getSchedulerJobs()) {

			if (!schJob.getIsEnabled())
				continue;

			JobDetail job = new JobDetail();
			job.setName(schJob.getJobName());
			job.setDescription(schJob.getDescription());
			job.setGroup("STAR_SCHEDULER");
			job.setJobClass(starUtilService.createService(schJob.getEntityName()).getClass());
			jobArr.add(job);

			SimpleTrigger trigger = new SimpleTrigger(job.getName(), job.getGroup());
			trigger.setDescription(job.getDescription());
			trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
			trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			trigger.setRepeatInterval(schJob.getRepeatedIntrvl());
			triggerArr.add(trigger);

		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("UTIL_SERVICE", starUtilService);
		dataMap.put("EMAIL_INFO", defEmailInfo);
		dataMap.put("EMAIL_SERVICE", emailService);

		try {
			schedulerObj.getContext().put("DATA_MAP", dataMap);
			schedulerObj.start();
			if (schedulerObj.isStarted()) {
				for (int i = 0; i < jobArr.size(); i++)

					schedulerObj.scheduleJob(jobArr.get(i), triggerArr.get(i));

			}

			isStarted = Boolean.TRUE;
			appScheduler.setStartedOn(new Date());
			appScheduler.setStatus("STARTED");

		} catch (Exception e) {
			isStarted = Boolean.FALSE;
		}

		return isStarted;

	}

}
