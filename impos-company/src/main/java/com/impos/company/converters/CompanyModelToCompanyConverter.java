package com.impos.company.converters;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;
import com.impos.company.model.CompanyBranchModel;
import com.impos.company.model.CompanyModel;

@Component("companyModelToCompanyConverter")
public class CompanyModelToCompanyConverter implements Converter<CompanyModel, Company> {
	@Autowired
	private ObjectFactory<Company> companyFactory;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private CompanyBranchModelToCompanyBranchConverter tempCompanyBranchModelToDomainConverter;

	@Override
	public Company convert(CompanyModel source) {
		Company company = companyFactory.getObject();
		BeanUtils.copyProperties(source, company);
		if (CollectionUtils.isNotEmpty(source.getCompanyBranchModels())) {
			Set<CompanyBranch> companyBranches = new HashSet<>();
			for (CompanyBranchModel companyBranchModel : source.getCompanyBranchModels()) {
				companyBranches.add(tempCompanyBranchModelToDomainConverter.convert(companyBranchModel));
			}
			company.setCompanyBranchs(companyBranches);
		}

		return company;
	}

	@Autowired
	public void setDepartmentFactory(final ObjectFactory<Company> companyFactory) {
		this.companyFactory = companyFactory;
	}
}
