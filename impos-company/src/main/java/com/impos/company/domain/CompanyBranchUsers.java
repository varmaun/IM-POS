package com.impos.company.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.impos.user.domain.Users;

@Table(name = "company_branch_users")
@Entity
@Component
public class CompanyBranchUsers extends AbstractDomain {

	private Users userId;
	private Company companyId;
	private CompanyBranch companyBranchId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_branch_id", nullable = false)
	public CompanyBranch getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(CompanyBranch companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

}
