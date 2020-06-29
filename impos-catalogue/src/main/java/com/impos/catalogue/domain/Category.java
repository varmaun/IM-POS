package com.impos.catalogue.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "category")
@Entity
@Component
public class Category extends AbstractDomain{
	
	private String name;
	private String parentCategoryId;
	private String companyId;
	private Boolean isActive;
	
	public Category() {
		
	}

	public Category(String name, String parentCategoryId, String companyId, Boolean isActive) {
		super();
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.companyId = companyId;
		this.isActive = isActive;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "parent_category_id")
	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
