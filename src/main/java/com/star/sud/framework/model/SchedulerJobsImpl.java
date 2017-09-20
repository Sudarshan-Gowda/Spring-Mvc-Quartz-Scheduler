package com.star.sud.framework.model;
/*created by Sudarshan on 19-09-17*/
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STAR_SCHEDULER_JOBS")
public class SchedulerJobsImpl implements SchedulerJobs {

	@Id
	@GenericGenerator(name = "generic_Id", strategy = "increment")
	@GeneratedValue(generator = "generic_Id")
	@Column(name = "STAR_ID", unique = true, nullable = false)
	protected Long id;

	@Column(name = "JOB_NAME")
	protected String jobName;

	@Column(name = "DESCRIPTION")
	protected String description;

	@Column(name = "START_TIME")
	@Temporal(TemporalType.DATE)
	protected Date startTime;

	@Column(name = "END_TIME")
	@Temporal(TemporalType.DATE)
	protected Date endTime;

	@Column(name = "STATUS")
	protected String status;

	@Column(name = "STARTED_ON")
	@Temporal(TemporalType.DATE)
	protected Date startedOn;

	@Column(name = "ENDED_ON")
	@Temporal(TemporalType.DATE)
	protected Date endedOn;

	@Column(name = "ENTITY_NAME")
	protected String entityName;

	@Column(name = "REPEATED_INTERVAL")
	protected Long repeatedIntrvl;

	@Column(name = "IS_ENABLED")
	protected Boolean isEnabled;

	@ManyToOne(targetEntity = ApplicationSchedulerImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "STAR_ID")
	protected ApplicationScheduler applicationScheduler;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}

	public Date getEndedOn() {
		return endedOn;
	}

	public void setEndedOn(Date endedOn) {
		this.endedOn = endedOn;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Long getRepeatedIntrvl() {
		return repeatedIntrvl;
	}

	public void setRepeatedIntrvl(Long repeatedIntrvl) {
		this.repeatedIntrvl = repeatedIntrvl;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public ApplicationScheduler getApplicationScheduler() {
		return applicationScheduler;
	}

	public void setApplicationScheduler(ApplicationScheduler applicationScheduler) {
		this.applicationScheduler = applicationScheduler;
	}

}
