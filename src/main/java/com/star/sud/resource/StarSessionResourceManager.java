package com.star.sud.resource;
/*created by Sudarshan on 19-09-17*/
import org.springframework.stereotype.Service;

import com.star.sud.security.model.StarUser;

@Service("starSessionResourceManager")
public class StarSessionResourceManager {

	protected StarUser loggedInUser;

	public StarUser getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(StarUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

}
