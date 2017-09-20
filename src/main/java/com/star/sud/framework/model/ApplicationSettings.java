package com.star.sud.framework.model;
/*created by Sudarshan on 19-09-17*/
public interface ApplicationSettings {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public Boolean getIsEnabled();

	public void setIsEnabled(Boolean isEnabled);

	public ApplicationScheduler getScheduler();

	public void setScheduler(ApplicationScheduler scheduler);

}
