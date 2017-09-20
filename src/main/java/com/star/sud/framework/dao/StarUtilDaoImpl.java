package com.star.sud.framework.dao;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.star.sud.EntityConfiguration;
import com.star.sud.paging.StarFilter;
import com.star.sud.paging.StarFilterValueKey;
import com.star.sud.paging.StarOperator;
import com.star.sud.paging.StarPageResultList;
import com.star.sud.security.model.StarUser;

@Repository("starUtilDao")
public class StarUtilDaoImpl implements StarUtilDao {

	@PersistenceContext(unitName = "star")
	private EntityManager em;

	@Resource(name = "starEntityConfiguration")
	protected EntityConfiguration entityConfiguration;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> readAllEntities(String entityClass, Map<String, StarFilter> filters) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final List<Predicate> predicates = new ArrayList<Predicate>();
		Object obj = entityConfiguration.createEntityInstance(entityClass);
		final CriteriaQuery query = cb.createQuery(obj.getClass());
		final Root root = query.from(obj.getClass());
		Path tmpRoot = null;
		for (String key : filters.keySet()) {
			String[] aKeyArr = key.split("\\.");
			tmpRoot = root;
			for (String str : aKeyArr)
				tmpRoot = tmpRoot.get(str);
			StarFilter starFilter = filters.get(key);
			predicates.add(cb.equal(tmpRoot, starFilter.getValue()));

		}
		if (predicates.size() > 0)
			query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		query.select(cb.count(root));
		query.select(root);
		Query que = em.createQuery(query);

		return (List<Object>) que.getResultList();
	}

	@Override
	public Object createService(String entityClass) {
		return entityConfiguration.createEntityInstanceFromAppContext(entityClass);
	}

	@Override
	public Object save(Object entity) {
		return em.merge(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	/**********************/
	public StarPageResultList readAllEntitiesWthFilter(Object entity, StarPageResultList paging, StarUser user,
			Map<String, StarFilter> screenfilters) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final List<Predicate> predicates = new ArrayList<Predicate>();
		final CriteriaQuery query = cb.createQuery(entity.getClass());
		final Root root = query.from(entity.getClass());
		String auditableFilter = paging.getAuditableFilter();
		Path tmpRoot = root;

		Map<String, StarFilter> filters = paging.getFilters();
		tmpRoot = null;
		for (String key : filters.keySet()) {

			String[] aKeyArr = key.split("\\.");
			tmpRoot = root;
			for (String str : aKeyArr)
				tmpRoot = tmpRoot.get(str);

			Predicate pr = null;
			StarFilter fil = filters.get(key);

			if (fil.getType().equals("NUMBER") || fil.getType().equals("AMOUNT") || fil.getType().equals("FLOAT")
					|| fil.getType().equals("BOOLEAN"))
				pr = cb.equal(tmpRoot, fil.getValue());
			else
				pr = cb.like(tmpRoot, "%" + fil.getValue() + "%");

			if (pr != null)
				predicates.add(pr);
		}

		if (screenfilters != null) {
			predicates.addAll(processScreenFilters(predicates, cb, root, screenfilters, user));
		}

		if (predicates.size() > 0)
			query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

		query.select(cb.count(root));
		paging.setTotalRecords(((Long) em.createQuery(query).getSingleResult()).intValue());

		if (paging.getTotalRecords() > 1) {
			String sortField = paging.getSortField();
			if (sortField != null && !sortField.equals("")) {
				String[] aSortArr = sortField.split("\\.");
				Path tmpRoot1 = root;
				for (String str : aSortArr)
					tmpRoot1 = tmpRoot1.get(str);
				if (paging.getSort().equals("ASC"))
					query.orderBy(cb.asc(tmpRoot1));
				else if (paging.getSort().equals("DESC"))
					query.orderBy(cb.desc(tmpRoot1));
			}
		}
		query.select(root);
		Query que = em.createQuery(query);

		if (paging.getStart() > 0)
			que.setFirstResult(paging.getStart() - 1);
		que.setMaxResults(paging.getRecordsPerPage());
		paging.setEntityList((List<Object>) que.getResultList());
		return paging;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Predicate> processScreenFilters(List<Predicate> predicates, CriteriaBuilder cb, Root root,
			Map<String, StarFilter> screenfilters, StarUser user) {

		Path tmpRoot = null;

		StarFilter filter = null;
		for (String key : screenfilters.keySet()) {

			filter = screenfilters.get(key);

			String[] aKeyArr = key.split("\\.");
			tmpRoot = root;
			for (String str : aKeyArr) {

				tmpRoot = tmpRoot.get(str);
			}

			Object value;

			if (filter.getValueKey() != null && !filter.getValueKey().equals(""))

				value = processValueKey(filter.getValueKey(), user);

			else
				value = filter.getValue();

			if (filter.getOperator() == StarOperator.EQUALS) {

				predicates.add(cb.equal(tmpRoot, value));

			} else if (filter.getOperator() == StarOperator.NOT_EQUAL) {

				predicates.add(cb.notEqual(tmpRoot, value));
			}

			else if (filter.getOperator() == StarOperator.IN_SET) {
				In in = cb.in(tmpRoot);
				in.value(value);
				predicates.add(in);
			}
		}

		return predicates;
	}

	private Object processValueKey(Object valueKey, StarUser user) {

		Object value = null;

		if (valueKey.equals(StarFilterValueKey.LOGIN_USER.toString())) {
			// value = user.getId();
		}

		else if (valueKey.equals(StarFilterValueKey.LOGIN_BRANCH.toString())) {
			value = user;
		}

		else if (valueKey.equals(StarFilterValueKey.USER_ROLE.toString())) {

			value = user;
		}

		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T createEntityObj(String entityClass, Class<T> type) {
		return (T) create(entityClass);
	}

	public Object create(String entityClass) {
		return entityConfiguration.createEntityInstance(entityClass);

	}

}
