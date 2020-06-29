package com.impos.settings.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "department")
@Entity
@Component
public class Department extends AbstractDomain  {

	private String name;
	private Boolean isActive;
	private String companyId;

	public Department() {
	}

	public Department(String name, Boolean isActive, String companyId) {
		super();
		this.name = name;
		this.isActive = isActive;
		this.companyId = companyId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
