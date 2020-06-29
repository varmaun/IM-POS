package com.impos.company.domain;

import java.util.HashSet;
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

@Table(name = "company")
@Entity
@Component
public class Company extends AbstractDomain {

	private String name, entityName, gstNo, billingAddress;
	private Boolean status;
	private Set<CompanyBranch> companyBranchs = new HashSet<>();

	public Company(String id) {
		this.id = id;
	}

	public Company() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyId")
	public Set<CompanyBranch> getCompanyBranchs() {
		return companyBranchs;
	}

	public void setCompanyBranchs(Set<CompanyBranch> companyBranchs) {
		this.companyBranchs = companyBranchs;
	}

}
