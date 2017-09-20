package com.star.sud.framework;
/*created by Sudarshan on 19-09-17*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Scheduler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.star.sud.framework.model.ApplicationScheduler;
import com.star.sud.framework.model.ApplicationSettings;
import com.star.sud.framework.service.StarUtilService;
import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarOperator;
import com.star.sud.scheduler.StarSchedulerService;

public class StarInitializer implements ApplicationContextAware {

	@Resource(name = "starUtilService")
	protected StarUtilService starUtilService;

	@Resource(name = "starSchedulerService")
	protected StarSchedulerService starSchedulerService;

	private static ApplicationContext applicationContext = null;
	private static Map<String, Object> starGlobalResource = new HashMap<String, Object>();

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContextObj) throws BeansException {

		Map<String, StarFilter> filterMap = new HashMap<String, StarFilter>();
		filterMap.put("isEnabled", new StarFilter("isEnabled", Boolean.TRUE, "BOOLEAN", StarOperator.EQUALS));
		List<Object> appSettings = starUtilService.findAllEntities(ApplicationSettings.class.getName(), filterMap);

		ApplicationSettings defAppSettings = null;

		if (appSettings.size() > 0) {
			defAppSettings = (ApplicationSettings) appSettings.get(0);
		}

		setStarGlobalResource("APP_SETTINGS", defAppSettings);

		ApplicationScheduler appScheduler = defAppSettings.getScheduler();
		if (appScheduler != null && appScheduler.getIsEnabled()) {

			Scheduler scheduler = starSchedulerService.createScheduler();
			starGlobalResource.put("STAR_SCHDULER", scheduler);
			starSchedulerService.startScheduler(scheduler, appScheduler);
			starUtilService.save(appScheduler);
		}
		applicationContext = applicationContextObj;

	}

	public static void setStarGlobalResource(String key, Object value) {

		starGlobalResource.put(key, value);
	}

	public static Map<String, Object> getStarGlobalResource() {
		return starGlobalResource;
	}
}
