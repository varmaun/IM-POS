package com.impos.company.businessdelegate;

import static org.springframework.core.convert.TypeDescriptor.forObject;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.company.businessdelegate.context.CompanyBranchUsersContext;
import com.impos.company.converters.CompanyBranchUsersModelToCompanyBranchUsersConverter;
import com.impos.company.converters.CompanyBranchUsersToCompanyBranchUsersModelConverter;
import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.model.CompanyBranchUsersModel;
import com.impos.company.service.ICompanyBranchUsersService;

/*
*@Author varma
*/

@Service

public class CompanyBranchUsersBusinessDelegate
		implements IBusinessDelegate<CompanyBranchUsersModel, CompanyBranchUsersContext, IKeyBuilder<String>, String> {

	@Autowired
	private ICompanyBranchUsersService companyBranchUsersService;
	@Autowired
	private CompanyBranchUsersToCompanyBranchUsersModelConverter tempCompanyBranchUsersToCompanyBranchUsersModelConverter;
	@Autowired
	private CompanyBranchUsersModelToCompanyBranchUsersConverter tempCompanyBranchUsersModelToCompanyBranchUsersConverter;
	@Autowired
	private ConversionService conversionService;

	@Override
	@Transactional
	public CompanyBranchUsersModel create(CompanyBranchUsersModel model) {
//		CompanyBranchUsers companyBranchUsers = companyBranchUsersService.create((CompanyBranchUsers) conversionService
//				.convert(model, forObject(model), valueOf(CompanyBranchUsers.class)));
//		model = convertToCompanyBranchUsersModel(companyBranchUsers);
		model = tempCompanyBranchUsersToCompanyBranchUsersModelConverter.convert(companyBranchUsersService
				.create(tempCompanyBranchUsersModelToCompanyBranchUsersConverter.convert(model)));

		return model;
	}

	private CompanyBranchUsersModel convertToCompanyBranchUsersModel(CompanyBranchUsers companyBranchUsers) {
		return (CompanyBranchUsersModel) conversionService.convert(companyBranchUsers, forObject(companyBranchUsers),
				valueOf(CompanyBranchUsersModel.class));
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CompanyBranchUsersContext context) {

	}

	@Override
	public CompanyBranchUsersModel edit(IKeyBuilder<String> keyBuilder, CompanyBranchUsersModel model) {
		CompanyBranchUsers companyBranchUsers = companyBranchUsersService
				.getCompanyBranchUsers(keyBuilder.build().toString());

//		companyBranchUsers = companyBranchUsersService.updateCompanyBranchUsers((CompanyBranchUsers) conversionService
//				.convert(model, forObject(model), valueOf(CompanyBranchUsers.class)));
//		model = convertToCompanyBranchUsersModel(companyBranchUsers);
		model = tempCompanyBranchUsersToCompanyBranchUsersModelConverter.convert(companyBranchUsersService
				.updateCompanyBranchUsers(tempCompanyBranchUsersModelToCompanyBranchUsersConverter.convert(model)));

		return model;
	}

	@Override
	public CompanyBranchUsersModel getByKey(IKeyBuilder<String> keyBuilder, CompanyBranchUsersContext context) {
		CompanyBranchUsers companyBranchUsers = companyBranchUsersService
				.getCompanyBranchUsers(keyBuilder.build().toString());
		CompanyBranchUsersModel model = tempCompanyBranchUsersToCompanyBranchUsersModelConverter
				.convert(companyBranchUsers);
		return model;
	}

	@Override
	public Collection<CompanyBranchUsersModel> getCollection(CompanyBranchUsersContext context) {

		List<CompanyBranchUsersModel> companyBranchUserModels = new ArrayList<>();

		for (CompanyBranchUsers branchUsers : companyBranchUsersService.getAll(context)) {

			companyBranchUserModels.add(tempCompanyBranchUsersToCompanyBranchUsersModelConverter.convert(branchUsers));

		}

//		List<CompanyBranchUsers> companyBranchUsers = new ArrayList<CompanyBranchUsers>();

//		List<CompanyBranchUsersModel> companyBranchUsersModels = (List<CompanyBranchUsersModel>) conversionService
//				.convert(companyBranchUsers, TypeDescriptor.forObject(companyBranchUsers),
//						TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CompanyBranchUsersModel.class)));
		return companyBranchUserModels;
	}

	@Override
	public CompanyBranchUsersModel edit(IKeyBuilder<String> keyBuilder, CompanyBranchUsersModel model,
			CompanyBranchUsersContext context) {
		return null;
	}

}
