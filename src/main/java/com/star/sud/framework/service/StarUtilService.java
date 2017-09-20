package com.star.sud.framework.service;
/*created by Sudarshan on 19-09-17*/
import java.util.List;
import java.util.Map;

import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarPageResultList;
import com.star.sud.security.model.StarUser;

public interface StarUtilService {

	public List<Object> findAllEntities(String entityClass, Map<String, StarFilter> filters);

	public Object createService(String entityClass);

	public Object save(Object entity);

	public StarPageResultList findAllEntitiesWithPaging(Object entity, StarPageResultList paging, StarUser user,
			Map<String, StarFilter> screenFilter);

	public <T> T createEntityObj(String entityClass, Class<T> type);

}
