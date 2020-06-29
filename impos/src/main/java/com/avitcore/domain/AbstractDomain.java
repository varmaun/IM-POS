package com.avitcore.domain;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MappedSuperclass
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractDomain implements IDomain {

	private static final long serialVersionUID = 3335139150820323595L;
	protected String id;
	protected String userCreated;
	protected String userModified;
	protected LocalDateTime createdDate;
	protected LocalDateTime modifiedDate;

	@Override
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return id;
	}

	@Override
	public void setId(final String id) {
		this.id = id;
	}

	@Column(name = "user_created")
	@CreatedBy
	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	@Column(name = "user_modified")
	@LastModifiedBy
	public String getUserModified() {
		return userModified;
	}

	public void setUserModified(String userModified) {
		this.userModified = userModified;
	}
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name = "created_date", nullable = false, length = 19, insertable = true, updatable = false)
	@CreatedDate
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name = "modified_date", nullable = false, length = 19, insertable = false, updatable = true)
	@LastModifiedDate
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
