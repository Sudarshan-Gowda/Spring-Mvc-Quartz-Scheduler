package com.star.sud.security.dao;
/*@Author Sudarshan*/
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.star.sud.security.model.StarUser;

@Service("starSecurityDao")
public class StarSecurityDaoImpl implements StarSecurityDao {

	@PersistenceContext(unitName = "star")
	private EntityManager em;

	public StarUser readSysUserByUserName(String userName) {

		Query query = em.createQuery(
				"SELECT entity from " + StarUser.class.getName() + " entity where entity.userName= :userName");

		query.setParameter("userName", userName);

		StarUser user = null;
		try {
			user = (StarUser) query.getSingleResult();
		} catch (NoResultException exp) {
		}
		return user;
	}

	public StarUser readSysUserByUserName(String userName, String password) {

		Query query = em.createQuery("select entity from " + StarUser.class.getName()
				+ " entity where entity.userName := userName and entity.password=: password"/*
																							 * ,
																							 */);

		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return (StarUser) query.getSingleResult();

	}

}
