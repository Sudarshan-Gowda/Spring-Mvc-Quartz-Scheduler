package com.star.sud.security.service;
/*@Author Sudarshan*/
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.star.sud.security.dao.StarSecurityDao;
import com.star.sud.security.model.StarUser;

@Service("starSecurityService")
public class StarSecurityServiceImpl implements StarSecurityService {

	@Resource(name = "starSecurityDao")
	protected StarSecurityDao starSecurityDao;

	public StarUser findSysUserName(String userName) {

		return starSecurityDao.readSysUserByUserName(userName);
	}

	public StarUser findSysUserName(String userName, String password) {

		return starSecurityDao.readSysUserByUserName(userName, password);
	}

}
