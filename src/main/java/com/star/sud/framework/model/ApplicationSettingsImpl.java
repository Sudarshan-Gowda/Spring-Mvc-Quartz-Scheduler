package com.star.sud.framework.model;
/*created by Sudarshan on 19-09-17*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STAR_APPLICATION_SETTINGS")
public class ApplicationSettingsImpl implements ApplicationSettings {

	@Id
	@GenericGenerator(name = "Currency_Id", strategy = "increment")
	@GeneratedValue(generator = "Currency_Id")
	@Column(name = "STAR_ID", unique = true, nullable = false)
	protected Long id;

	@Column(name = "SETT_NAME")
	protected String name;

	@Column(name = "IS_ENABLED")
	protected Boolean isEnabled = Boolean.TRUE;

	@OneToOne(targetEntity = ApplicationSchedulerImpl.class)
	@JoinColumn(name = "SCHED_ID", referencedColumnName = "STAR_ID")
	protected ApplicationScheduler scheduler;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	@Override
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public ApplicationScheduler getScheduler() {
		return scheduler;
	}

	@Override
	public void setScheduler(ApplicationScheduler scheduler) {
		this.scheduler = scheduler;
	}

}
