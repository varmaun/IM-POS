package com.impos.company.service;

import java.util.List;

import com.impos.company.businessdelegate.context.CompanyBranchContext;
import com.impos.company.domain.CompanyBranch;

/*
*@Author varma
*/
public interface ICompanyBranchService {

	CompanyBranch create(CompanyBranch companyBranch);

	void deleteCompanyBranch(String companyBranchId);

	CompanyBranch getCompanyBranch(String companyBranchId);

	List<CompanyBranch> getAll(CompanyBranchContext context);

	CompanyBranch updateCompanyBranch(CompanyBranch companyBranch);
}
