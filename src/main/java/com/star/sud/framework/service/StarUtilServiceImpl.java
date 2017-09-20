package com.star.sud.framework.service;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.star.sud.framework.dao.StarUtilDao;
import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarPageResultList;
import com.star.sud.security.model.StarUser;

@Service("starUtilService")
public class StarUtilServiceImpl implements StarUtilService {

	@Resource(name = "starUtilDao")
	protected StarUtilDao starUtilDao;

	@Override
	public List<Object> findAllEntities(String entityClass, Map<String, StarFilter> filters) {

		return starUtilDao.readAllEntities(entityClass, filters);
	}

	@Override
	public Object createService(String entityClass) {
		return starUtilDao.createService(entityClass);
	}

	@Override
	@Transactional
	public Object save(Object entity) {

		return starUtilDao.save(entity);
	}

	@Override
	public StarPageResultList findAllEntitiesWithPaging(Object entity, StarPageResultList paging, StarUser user,
			Map<String, StarFilter> screenFilter) {

		String strFilter = paging.getCurrentFilter();
		paging.setFilters(paging.getFilterListAsMap());
		if (strFilter != null && !strFilter.equals("")) {
			String op = strFilter.contains("=") ? "FILTER" : "RESET";

			String[] filterValArr = strFilter.split("~");

			if (op.equals("FILTER")) {
				String[] filterVal = filterValArr[1].split("=");

				Object val = filterVal[1];
				if (filterValArr[0].equals("BOOLEAN")) {
					if (filterVal[1].equals("true"))
						val = Boolean.TRUE;
					else
						val = Boolean.FALSE;
				}
				paging.getFilters().put(filterVal[0],
						new StarFilter().key(filterVal[0]).value(val).type(filterValArr[0]));
			} else {
				paging.getFilters().remove(strFilter);
			}
			List<StarFilter> filList = new ArrayList<StarFilter>(paging.getFilters().values());
			paging.setFilterList(filList);
		}
		return starUtilDao.readAllEntitiesWthFilter(entity, paging, user, screenFilter);
	}

	@Override
	public <T> T createEntityObj(String entityClass, Class<T> type) {
		return starUtilDao.createEntityObj(entityClass, type);
	}

}
