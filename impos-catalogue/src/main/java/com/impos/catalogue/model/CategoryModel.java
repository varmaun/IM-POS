package com.impos.catalogue.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("categoryModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryModel extends AbstractModel{
	
	private String name;
	private String parentCategoryId;
	private String companyId;
	private Boolean isActive;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
