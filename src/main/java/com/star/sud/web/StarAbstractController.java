package com.star.sud.web;

import javax.annotation.Resource;

import com.star.sud.StarSystemProperties;
import com.star.sud.framework.service.StarUtilService;
import com.star.sud.security.service.StarSecurityService;
import com.star.sud.user.account.service.StarUserAcccountService;

public abstract class StarAbstractController {

	@Resource(name = "starUtilService")
	protected StarUtilService starUtilService;

	@Resource(name = "starUserAcccountService")
	public StarUserAcccountService userAcccountService;

	@Resource(name = "starSecurityService")
	protected StarSecurityService starSecurityService;

	protected static final String STAR_MESSAGE = "starMessage";

	@Resource(name = "starSystemProperties")
	protected StarSystemProperties starSystemProperties;

}
