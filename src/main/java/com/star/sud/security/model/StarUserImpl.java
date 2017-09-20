package com.star.sud.security.model;

/*@Author Sudarshan*/
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Entity
@Table(name = "STAR_SM_USER")
public class StarUserImpl implements StarUser {

	@Id
	@GenericGenerator(name = "genericId", strategy = "increment")
	@GeneratedValue(generator = "genericId")
	@Column(name = "STAR_ID")
	protected Long id;

	@Column(name = "USER_NAME")
	protected String userName;

	@Column(name = "USER_PASSWORD")
	protected String password;

	@Column(name = "IS_ENABLED")
	protected Boolean isEnabled;

	@OneToOne(targetEntity = StarUserDetailsImpl.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	protected StarUserDetails starUserDetails = new StarUserDetailsImpl();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		this.password = encoder.encodePassword(password, null);
	}

	public List<StarUserRole> getRoles() {
		List<StarUserRole> roles = new ArrayList<StarUserRole>();

		return roles;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public StarUserDetails getStarUserDetails() {
		return starUserDetails;
	}

	@Override
	public void setStarUserDetails(StarUserDetails starUserDetails) {
		this.starUserDetails = starUserDetails;
	}

}
