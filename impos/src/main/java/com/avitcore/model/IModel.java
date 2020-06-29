package com.avitcore.model;

import java.io.Serializable;

/**
 * @author varma
 *
 */
public interface IModel extends Serializable {

	/**
	 * @return
	 */
	String getId();

	/**
	 * @param id
	 */
	void setId(String id);

	public String getCreatedDate();

	public void setCreatedDate(String createdDate);

	public String getModifiedDate();

	public void setModifiedDate(String modifiedDate);

	public String getUserCreated();

	public void setUserCreated(String userCreated);

	public String getUserModified();

	public void setUserModified(String userModified);
}
