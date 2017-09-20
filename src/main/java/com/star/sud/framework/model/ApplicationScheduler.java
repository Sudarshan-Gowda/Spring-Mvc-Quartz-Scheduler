package com.star.sud.framework.model;

import java.util.Date;
import java.util.List;

public interface ApplicationScheduler {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public Date getStartedOn();

	public void setStartedOn(Date startedOn);

	public String getStatus();

	public void setStatus(String status);

	public Date getLastChangedOn();

	public void setLastChangedOn(Date lastChangedOn);

	public Boolean getIsEnabled();

	public void setIsEnabled(Boolean isEnabled);

	public List<SchedulerJobs> getSchedulerJobs();

	public void setSchedulerJobs(List<SchedulerJobs> schedulerJobs);

}
