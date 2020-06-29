package com.impos.company.service;

import java.util.List;

import com.impos.company.businessdelegate.context.CompanyContext;
import com.impos.company.domain.Company;

public interface ICompanyService {
	Company create(Company company);

	void deleteCompany(String companyId);

	Company getCompany(String companyId);

	List<Company> getAll();

	Company updateCompany(Company company);

	List<Company> getAll(CompanyContext context);
}
