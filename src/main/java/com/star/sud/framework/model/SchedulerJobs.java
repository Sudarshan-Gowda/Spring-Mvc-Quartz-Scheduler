package com.star.sud.framework.model;
/*created by Sudarshan on 19-09-17*/

import java.util.Date;

public interface SchedulerJobs {

	public Long getId();

	public void setId(Long id);

	public String getJobName();

	public void setJobName(String jobName);

	public String getDescription();

	public void setDescription(String description);

	public Date getStartTime();

	public void setStartTime(Date startTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public String getStatus();

	public void setStatus(String status);

	public Date getStartedOn();

	public void setStartedOn(Date startedOn);

	public Date getEndedOn();

	public void setEndedOn(Date endedOn);

	public String getEntityName();

	public void setEntityName(String entityName);

	public Long getRepeatedIntrvl();

	public void setRepeatedIntrvl(Long repeatedIntrvl);

	public Boolean getIsEnabled();

	public void setIsEnabled(Boolean isEnabled);

	public ApplicationScheduler getApplicationScheduler();

	public void setApplicationScheduler(ApplicationScheduler applicationScheduler);

}
