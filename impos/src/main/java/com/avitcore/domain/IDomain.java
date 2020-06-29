package com.avitcore.domain;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

/**
 * @author Jay
 *
 */
public interface IDomain extends Serializable {

	/**
	 * @return
	 */
	public String getId();

	/**
	 * @param id
	 */
	public void setId(String id);

	public LocalDateTime getCreatedDate();

	public void setCreatedDate(LocalDateTime createdDate);

	public LocalDateTime getModifiedDate();

	public void setModifiedDate(LocalDateTime modifiedDate);

	public String getUserCreated();

	public void setUserCreated(String userCreated);

	public String getUserModified();

	public void setUserModified(String userModified);

}