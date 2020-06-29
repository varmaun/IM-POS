/**
 *
 */
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

import com.impos.company.domain.CompanyBranch;
import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.model.CompanyBranchModel;
import com.impos.company.model.CompanyBranchUsersModel;

/**
 * @author Jay
 *
 */
@Component("companyBranchModelToCompanyBranchConverter")
public class CompanyBranchModelToCompanyBranchConverter implements Converter<CompanyBranchModel, CompanyBranch> {
	@Autowired
	private ObjectFactory<CompanyBranch> companyBranchFactory;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private CompanyBranchUsersModelToCompanyBranchUsersConverter tempCompanyBranchModelToCompanyBranchConverter;

	@Override
	public CompanyBranch convert(final CompanyBranchModel source) {
		CompanyBranch companyBranch = companyBranchFactory.getObject();
		BeanUtils.copyProperties(source, companyBranch);
		if (CollectionUtils.isNotEmpty(source.getCompanyBranchUsersModels())) {
			Set<CompanyBranchUsers> companyBranchUsers = new HashSet<>();

			for (CompanyBranchUsersModel companyBranchUser : source.getCompanyBranchUsersModels()) {

				companyBranchUsers.add(tempCompanyBranchModelToCompanyBranchConverter.convert(companyBranchUser));

			}
			companyBranch.setCompanyBranchUser(companyBranchUsers);
		}

		return companyBranch;
	}

	@Autowired
	public void setCompanyBranchFactory(final ObjectFactory<CompanyBranch> companyBranchFactory) {
		this.companyBranchFactory = companyBranchFactory;
	}

}
