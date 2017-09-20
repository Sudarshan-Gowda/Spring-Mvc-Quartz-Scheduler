package com.star.sud.framework.model.notification;
/*created by Sudarshan on 19-09-17*/
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.star.sud.security.model.StarUser;
import com.star.sud.security.model.StarUserImpl;

@Entity
@Table(name = "STAR_MAIL_DETAIL")
public class StarMailDetailImpl implements StarMailDetail {

	@Id
	@GenericGenerator(name = "genericId", strategy = "increment")
	@GeneratedValue(generator = "genericId")
	@Column(name = "STAR_ID")
	protected Long id;

	@Column(name = "DATE_SCHED")
	protected Date dateScheduled;

	@Column(name = "DATE_SENT")
	protected Date dateSent;
	
	@Column(name = "STATUS")
	protected String status;

	@Column(name = "COMMENTS")
	protected String comments;

	@OneToOne(targetEntity = StarUserImpl.class, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "USER_ID", referencedColumnName = "STAR_ID")
	protected StarUser starUser;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Date getDateScheduled() {
		return dateScheduled;
	}

	@Override
	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	@Override
	public Date getDateSent() {
		return dateSent;
	}

	@Override
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getComments() {
		return comments;
	}

	@Override
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public StarUser getStarUser() {
		return starUser;
	}

	@Override
	public void setStarUser(StarUser starUser) {
		this.starUser = starUser;
	}

}
