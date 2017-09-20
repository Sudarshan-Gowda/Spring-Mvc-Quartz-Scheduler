package com.star.sud.security.model;

/*@Author Sudarshan*/
import java.util.List;

public interface StarUser {

	public Long getId();

	public void setId(Long id);

	public String getUserName();

	public void setUserName(String userName);

	public String getPassword();

	public void setPassword(String password);

	public List<StarUserRole> getRoles();

	public Boolean getIsEnabled();

	public void setIsEnabled(Boolean isEnabled);

	public StarUserDetails getStarUserDetails();

	public void setStarUserDetails(StarUserDetails starUserDetails);
}
