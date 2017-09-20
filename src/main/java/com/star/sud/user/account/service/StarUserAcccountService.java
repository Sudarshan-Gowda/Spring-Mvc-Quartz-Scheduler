package com.star.sud.user.account.service;
/*created by Sudarshan on 19-09-17*/
import com.star.sud.form.UserBasicInform;
import com.star.sud.security.model.StarUser;

public interface StarUserAcccountService {

	public StarUser storeUserInformation(StarUser user, UserBasicInform userBasicInform, Boolean registrn);

}
