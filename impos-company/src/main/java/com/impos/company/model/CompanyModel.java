package com.impos.company.model;

import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component("companyModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyModel extends AbstractModel {
	private String name, entityName, gstNo, billingAddress;
	private Boolean status;
	private Set<CompanyBranchModel> companyBranchModels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<CompanyBranchModel> getCompanyBranchModels() {
		return companyBranchModels;
	}

	public void setCompanyBranchModels(Set<CompanyBranchModel> companyBranchModels) {
		this.companyBranchModels = companyBranchModels;
	}

}
