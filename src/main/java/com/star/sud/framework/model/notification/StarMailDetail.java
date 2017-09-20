package com.star.sud.framework.model.notification;
/*created by Sudarshan on 19-09-17*/
import java.util.Date;

import com.star.sud.security.model.StarUser;

public interface StarMailDetail {

	public Long getId();

	public void setId(Long id);

	public Date getDateScheduled();

	public void setDateScheduled(Date dateScheduled);

	public Date getDateSent();

	public void setDateSent(Date dateSent);

	public String getStatus();

	public void setStatus(String status);

	public String getComments();

	public void setComments(String comments);

	public StarUser getStarUser();

	public void setStarUser(StarUser starUser);

}
