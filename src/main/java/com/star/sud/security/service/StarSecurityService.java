package com.star.sud.security.service;
/*@Author Sudarshan*/
import com.star.sud.security.model.StarUser;

public interface StarSecurityService {

	public StarUser findSysUserName(String userName);

	public StarUser findSysUserName(String userName, String password);

}
