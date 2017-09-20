package com.star.sud.security.dao;
/*@Author Sudarshan*/
import com.star.sud.security.model.StarUser;

public interface StarSecurityDao {

	public StarUser readSysUserByUserName(String userName);

	public StarUser readSysUserByUserName(String userName, String password);

}
