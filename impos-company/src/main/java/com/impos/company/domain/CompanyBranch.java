package com.impos.company.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "company_branch")
@Entity
@Component
public class CompanyBranch extends AbstractDomain {

	private String entityName, gstNo, billingAddress, franchiseCompanyId, branchType;
	private Boolean status;
	private Company companyId;
	private Set<CompanyBranchUsers> companyBranchUser;

	public CompanyBranch(String id) {
		this.id = id;
	}

	public CompanyBranch() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	@Column(name = "entity_name")
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Column(name = "gst_no")
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(name = "billing_address")
	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Column(name = "franchise_company_id")
	public String getFranchiseCompanyId() {
		return franchiseCompanyId;
	}

	public void setFranchiseCompanyId(String franchiseCompanyId) {
		this.franchiseCompanyId = franchiseCompanyId;
	}

	@Column(name = "branch_type")
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyBranchId")
	public Set<CompanyBranchUsers> getCompanyBranchUser() {
		return companyBranchUser;
	}

	public void setCompanyBranchUser(Set<CompanyBranchUsers> companyBranchUser) {
		this.companyBranchUser = companyBranchUser;
	}

}
