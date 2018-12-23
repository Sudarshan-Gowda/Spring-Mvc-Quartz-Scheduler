package com.star.sud.scheduler;

/*created by Sudarshan on 19-09-17*/
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import com.star.sud.framework.model.notification.StarMailDetail;
import com.star.sud.framework.service.StarUtilService;
import com.star.sud.framework.service.email.EmailInfo;
import com.star.sud.framework.service.email.EmailService;
import com.star.sud.framework.service.email.EmailStatus;
import com.star.sud.framework.service.email.EmailStatus.STATUS;
import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarOperator;
import com.star.sud.paging.StarPageResultList;
import com.star.sud.security.model.StarUser;

@Service("starMailerJob")
public class MailerJob implements Job {

	public MailerJob() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		SchedulerContext schedulerContext = null;

		try {
			schedulerContext = context.getScheduler().getContext();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		Map<String, Object> dataMap = (Map<String, Object>) schedulerContext.get("DATA_MAP");

		StarUtilService starUtilService = (StarUtilService) dataMap.get("UTIL_SERVICE");

		EmailInfo defEmailInfo = (EmailInfo) dataMap.get("EMAIL_INFO");
		EmailService emailService = (EmailService) dataMap.get("EMAIL_SERVICE");
		StarPageResultList paging = new StarPageResultList();

		StarMailDetail entity = (StarMailDetail) starUtilService.createService(StarMailDetail.class.getName());

		Map<String, StarFilter> screenFilters = new HashMap<String, StarFilter>();
		screenFilters.put("status", new StarFilter("status", "NEW", "TEXT", StarOperator.EQUALS));
		paging.setRecordsPerPage(50);
		paging = starUtilService.findAllEntitiesWithPaging(entity, paging, null, screenFilters);

		List<Object> entities = paging.getEntityList();

		for (Object mailDetailObj : entities) {
			StarMailDetail starMailDetail = (StarMailDetail) mailDetailObj;

			StarUser user = starMailDetail.getStarUser();

			EmailInfo emailInfo = new EmailInfo();
			emailInfo.setFromAddress(defEmailInfo.getFromAddress());
			emailInfo.setSubject("Registration Successfull!!");
			emailInfo.setMessageBody(
					"Dear " + user.getStarUserDetails().getFirstName() + " " + user.getStarUserDetails().getLastName()
							+ ", <br>  &nbsp;&nbsp;&nbsp;&nbsp; Congradulations! &nbsp;&nbsp Your Account is successfully created. <br> You can access your application with the credentail which you given while Registartion. "
							+ "<br><br><br><br><br><br><br>" + "Regards,<br>" + "Admin Be the Best");
			emailInfo.setEmailTo(user.getStarUserDetails().getEmail());

			EmailStatus emailStatus = emailService.sendMail(emailInfo);

			if (emailStatus != null && emailStatus.getStatus().equals(STATUS.SUCCESS)) {
				starMailDetail.setStatus("SENT");
				starMailDetail.setDateSent(new Date());
				starUtilService.save(starMailDetail);
			}

		}
	}

}
