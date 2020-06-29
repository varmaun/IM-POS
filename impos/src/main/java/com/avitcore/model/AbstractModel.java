package com.avitcore.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Jay
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractModel implements IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 872210719464832189L;
	protected String id;
	protected String userCreated;
	protected String userModified;
	protected String createdDate;
	protected String modifiedDate;

	/**
	 * {@inheritDoc}
	 *
	 * @see com.meat.businessdelegate.domain.IModel#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.meat.businessdelegate.domain.IModel#setId(java.lang.String)
	 */
	@Override
	public void setId(final String id) {
		this.id = id;

	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public String getUserModified() {
		return userModified;
	}

	public void setUserModified(String userModified) {
		this.userModified = userModified;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
