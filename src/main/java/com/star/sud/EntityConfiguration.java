package com.star.sud;

/*created by Sudarshan on 19-09-17*/

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

public class EntityConfiguration implements ApplicationContextAware {

	private static final Log LOG = LogFactory.getLog(EntityConfiguration.class);

	private ApplicationContext webApplicationContext;
	private ApplicationContext applicationcontext;

	@javax.annotation.Resource(name = "starMergedEntityContexts")
	protected Set<String> mergedEntityContexts;
	private Resource[] entityContexts;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.webApplicationContext = applicationContext;
	}

	@PostConstruct
	public void configureMergedItems() {
		Set<Resource> temp = new LinkedHashSet<Resource>();
		if (mergedEntityContexts != null && !mergedEntityContexts.isEmpty()) {
			for (String location : mergedEntityContexts) {
				location = location.trim();
				temp.add(webApplicationContext.getResource(location));
			}
		}
		if (entityContexts != null) {
			for (Resource resource : entityContexts) {
				temp.add(resource);
			}
		}
		entityContexts = temp.toArray(new Resource[temp.size()]);
		applicationcontext = new GenericXmlApplicationContext(entityContexts);
	}

	public Object createEntityInstance(String beanId) {
		Object bean = null;
		try {
			bean = applicationcontext.getBean(beanId);

			if (LOG.isDebugEnabled()) {

				LOG.debug("returning instance of class(" + bean.getClass().getName() + ") configured with bean id ("
						+ beanId + ')');

			}

		} catch (Exception exp) {
			bean = null;
		}
		return bean;
	}

	public Object createEntityInstanceFromAppContext(String beanId) {

		Object bean = webApplicationContext.getBean(beanId);
		if (LOG.isDebugEnabled()) {

			LOG.debug("Returning instance of class (" + bean.getClass().getName() + ") configured with bean id ("
					+ beanId + ')');
		}

		return bean;
	}

}
