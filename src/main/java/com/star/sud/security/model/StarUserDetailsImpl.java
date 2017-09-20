package com.star.sud.security.model;

/*@Author Sudarshan*/
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STAR_USER_REGISTRN")
public class StarUserDetailsImpl implements StarUserDetails {

	@Id
	@GenericGenerator(name = "genericId", strategy = "increment")
	@GeneratedValue(generator = "genericId")
	@Column(name = "STAR_ID")
	protected Long id;

	@Column(name = "FIRST_NAME")
	protected String firstName;

	@Column(name = "LAST_NAME")
	protected String lastName;

	@Column(name = "GENDER")
	protected String gender;

	@Column(name = "DOB")
	protected Date dob;

	@Column(name = "CONTACT_NUM")
	protected String contactNum;

	@Column(name = "EMAIL")
	protected String email;
	
	@MapsId
	@OneToOne(targetEntity = StarUserImpl.class, mappedBy = "starUserDetails", fetch = FetchType.LAZY)
	@JoinColumn(name = "STAR_ID")
	protected StarUser user;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public Date getDob() {
		return dob;
	}

	@Override
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String getContactNum() {
		return contactNum;
	}

	@Override
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public StarUser getUser() {
		return user;
	}

	@Override
	public void setUser(StarUser user) {
		this.user = user;
	}

}
