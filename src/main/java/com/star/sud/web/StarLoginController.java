package com.star.sud.web;

/*@Author Sudarshan*/
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.star.sud.SectionKeys;
import com.star.sud.StarDateUtil;
import com.star.sud.StarUrl;
import com.star.sud.StarUtil;
import com.star.sud.message.StarMessage;
import com.star.sud.message.StarMessageCode;
import com.star.sud.message.StarMessageType;
import com.star.sud.resource.StarResourceManager;
import com.star.sud.resource.StarSessionResourceManager;
import com.star.sud.sectionkey.StarConstants;
import com.star.sud.security.model.StarUser;

@Controller
public class StarLoginController extends StarAbstractController {

	private static final Logger logger = Logger.getLogger(StarLoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model, HttpSession session, @RequestParam Map<String, String> reqParams) {
		String starMessage = reqParams.get(STAR_MESSAGE);

		if (starMessage != null)
			model.addAttribute(STAR_MESSAGE, starMessage);
		reqParams.remove(STAR_MESSAGE);
		model.addAttribute(SectionKeys.REQ_PARAMS, StarUtil.getParamsAsString(reqParams));
		return "login/login-page";
	}

	@RequestMapping(value = StarUrl.LOGIN_FAILURE, method = RequestMethod.GET)
	public String loginFailureView(Model model, RedirectAttributes redirectAttributes) {

		StarMessage starMessage = null;
		starMessage = new StarMessage().code(StarMessageCode.INFORMATION).message("Invalid Credentials.")
				.type(StarMessageType.ERROR);
		redirectAttributes.addFlashAttribute(STAR_MESSAGE, starMessage);
		return StarConstants.REDIRECT_URL;
	}

	@RequestMapping(value = StarUrl.WELCOME, method = RequestMethod.GET)
	protected String welcome(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam Map<String, String> requestParam) {

		int sessionTomeout = 50000;
		String sesTimeout = starSystemProperties.getSessionTimeOut();
		if (sesTimeout != null && !sesTimeout.isEmpty()) {
			try {
				sessionTomeout = Integer.parseInt(sesTimeout);
			} catch (Exception e) {
			}
		}

		session.setMaxInactiveInterval(sessionTomeout);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		StarUser user = starSecurityService.findSysUserName(auth.getName());

		StarSessionResourceManager sessionResourceManager = new StarSessionResourceManager();
		sessionResourceManager.setLoggedInUser(user);
		session.setAttribute(StarResourceManager.STAR_SESSION_RESOURCE, sessionResourceManager);

		String loc = starSystemProperties.getLogfileLoc() + StarDateUtil.getTodayDateAsRev("/") + "/";
		updateLog4jConfiguration(loc + user.getUserName() + ".log", request);
		logger.debug("-- Debug message --");
		logger.info("-- Displaying info message--");

		if (request.getRemoteUser() != null) {

			model.addAttribute("userName", user.getUserName());
			return "welcome/welcome";
		} else {
			return StarConstants.REDIRECT_URL;
		}

	}

	@RequestMapping(value = StarUrl.LOGOUT_SUCESS, method = RequestMethod.GET)
	public String logoutSuccessView(Model model) {
		return StarConstants.REDIRECT_URL;
	}

	@RequestMapping(value = StarUrl.SESSION_EXPIRED, method = RequestMethod.GET)
	public String sesionExpired(Model model, RedirectAttributes redirectAttributes) {

		StarMessage starMessage = null;
		starMessage = new StarMessage().code(StarMessageCode.INFORMATION)
				.message("Session Expired. Login to Continue..").type(StarMessageType.ERROR);
		redirectAttributes.addFlashAttribute(STAR_MESSAGE, starMessage);

		return StarConstants.REDIRECT_URL;
	}

	private void updateLog4jConfiguration(String logFile, HttpServletRequest request) {
		Properties props = new Properties();
		try {
			InputStream configStream = getClass().getResourceAsStream("/log4j.properties");
			props.load(configStream);
			configStream.close();
		} catch (IOException e) {
		}

		props.setProperty("log4j.rootLogger", "DEBUG,Appender2");
		props.setProperty("log4j.appender.Appender2", "org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.Appender2.File", logFile);
		props.setProperty("log4j.appender.Appender2.MaxFileSize", "10MB");
		props.setProperty("log4j.appender.Appender2.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.Appender2.layout.ConversionPattern",
				"%d{dd MMM yyyy HH:mm:ss} " + StarUtil.getClientIPAddress(request) + " [%t] %-5p %c %x - %m%n");
		props.setProperty("log4j.logger.org.hibernate", "error");
		props.setProperty("log4j.logger.org.springframework", "error");
		props.setProperty("log4j.logger.org.thymeleaf", "error");

		LogManager.resetConfiguration();
		PropertyConfigurator.configure(props);

	}

}
