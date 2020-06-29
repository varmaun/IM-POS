/**
 *
 */
package com.impos.company.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;
import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.model.CompanyBranchUsersModel;
import com.impos.user.converters.UsersModelToUsersConverter;
import com.impos.user.domain.Users;

/**
 * @author Jay
 *
 */
@Component("companyBranchUsersModelToCompanyBranchUsersConverter")
public class CompanyBranchUsersModelToCompanyBranchUsersConverter
		implements Converter<CompanyBranchUsersModel, CompanyBranchUsers> {
	@Autowired
	private ObjectFactory<CompanyBranchUsers> companyBranchUsersFactory;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private UsersModelToUsersConverter tempUserModelToUserConverter;

	@Override
	public CompanyBranchUsers convert(final CompanyBranchUsersModel source) {
		CompanyBranchUsers companyBranchUsers = companyBranchUsersFactory.getObject();
		BeanUtils.copyProperties(source, companyBranchUsers);

		if (source.getCompanyBranchId() != null) {
			CompanyBranch branch = new CompanyBranch(source.getCompanyBranchId());
			companyBranchUsers.setCompanyBranchId(branch);
		}
		if (source.getCompanyId() != null) {

			Company company = new Company(source.getCompanyId());

			companyBranchUsers.setCompanyId(company);
		}
		if (source.getUserId() != null) {
			Users user = new Users(source.getUserId());
			companyBranchUsers.setUserId(user);
		}
		if (source.getUserModel() != null) {

			companyBranchUsers.setUserId(tempUserModelToUserConverter.convert(source.getUserModel()));
		}

		return companyBranchUsers;
	}

	@Autowired
	public void setCompanyBranchUsersFactory(final ObjectFactory<CompanyBranchUsers> companyBranchUsersFactory) {
		this.companyBranchUsersFactory = companyBranchUsersFactory;
	}

}
