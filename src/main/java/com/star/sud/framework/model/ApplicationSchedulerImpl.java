package com.star.sud.framework.model;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STAR_APPLICATION_SCHEDULER")
public class ApplicationSchedulerImpl implements ApplicationScheduler {

	@Id
	@GenericGenerator(name = "generic_Id", strategy = "increment")
	@GeneratedValue(generator = "generic_Id")
	@Column(name = "STAR_ID", unique = true, nullable = false)
	protected Long id;

	@Column(name = "SCHD_NAME")
	protected String name;

	@Column(name = "STARTED_ON")
	@Temporal(TemporalType.DATE)
	protected Date startedOn;

	@Column(name = "STATUS")
	protected String status;

	@Column(name = "LAST_CHANGED_ON")
	@Temporal(TemporalType.DATE)
	protected Date lastChangedOn;

	@Column(name = "IS_ENABLED")
	protected Boolean isEnabled;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = SchedulerJobsImpl.class, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "STAR_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<SchedulerJobs> schedulerJobs = new ArrayList<SchedulerJobs>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastChangedOn() {
		return lastChangedOn;
	}

	public void setLastChangedOn(Date lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<SchedulerJobs> getSchedulerJobs() {
		return schedulerJobs;
	}

	public void setSchedulerJobs(List<SchedulerJobs> schedulerJobs) {
		this.schedulerJobs = schedulerJobs;
	}

}
