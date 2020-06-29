package com.impos.company.model;

import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("companyBranchModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyBranchModel extends AbstractModel {

	private String companyId, entityName, gstNo, billingAddress, franchiseCompanyId, branchType;
	private Boolean status;

	private Set<CompanyBranchUsersModel> companyBranchUsersModels;

	private String companyName, franchiseCompanyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFranchiseCompanyName() {
		return franchiseCompanyName;
	}

	public void setFranchiseCompanyName(String franchiseCompanyName) {
		this.franchiseCompanyName = franchiseCompanyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public String getFranchiseCompanyId() {
		return franchiseCompanyId;
	}

	public void setFranchiseCompanyId(String franchiseCompanyId) {
		this.franchiseCompanyId = franchiseCompanyId;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<CompanyBranchUsersModel> getCompanyBranchUsersModels() {
		return companyBranchUsersModels;
	}

	public void setCompanyBranchUsersModels(Set<CompanyBranchUsersModel> companyBranchUsersModels) {
		this.companyBranchUsersModels = companyBranchUsersModels;
	}

}
