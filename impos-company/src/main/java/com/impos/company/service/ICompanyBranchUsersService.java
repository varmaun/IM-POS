package com.impos.company.service;

import java.util.List;

import com.impos.company.businessdelegate.context.CompanyBranchUsersContext;
import com.impos.company.domain.CompanyBranchUsers;
/*
*@Author varma
*/
public interface ICompanyBranchUsersService {
	
	CompanyBranchUsers create(CompanyBranchUsers companyBranchUsers);

	void deleteCompanyBranchUsers(String companyBranchUsersId);

	CompanyBranchUsers getCompanyBranchUsers(String companyBranchUsersId);

	List<CompanyBranchUsers> getAll(CompanyBranchUsersContext context);

	CompanyBranchUsers updateCompanyBranchUsers(CompanyBranchUsers companyBranchUsers);
}
