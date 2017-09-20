package com.star.sud.security.model;
/*@Author Sudarshan*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STAR_SM_USER_ROLE")
public class StarUserRoleImpl implements StarUserRole {
	@Id
	@GenericGenerator(name = "genericId", strategy = "increment")
	@GeneratedValue(generator = "genericId")
	@Column(name = "STAR_ID")
	protected Long id;

	@Column(name = "ROLE_NAME")
	protected String name;

	@Column(name = "ROLE_DESCRIPTION")
	protected String roleDescription;

	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

}
