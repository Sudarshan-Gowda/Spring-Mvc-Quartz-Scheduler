package com.star.sud.framework.dao;

import java.util.List;
import java.util.Map;

import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarPageResultList;
import com.star.sud.security.model.StarUser;

public interface StarUtilDao {

	public List<Object> readAllEntities(String entityClass, Map<String, StarFilter> filters);

	public Object createService(String entityClass);

	public Object save(Object entity);

	public StarPageResultList readAllEntitiesWthFilter(Object entity, StarPageResultList paging, StarUser user,
			Map<String, StarFilter> screenfilters);

	public <T> T createEntityObj(String entityClass, Class<T> type);
}
