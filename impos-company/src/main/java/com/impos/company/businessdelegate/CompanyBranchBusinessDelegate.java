package com.impos.company.businessdelegate;

import static org.springframework.core.convert.TypeDescriptor.forObject;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.company.businessdelegate.context.CompanyBranchContext;
import com.impos.company.converters.CompanyBranchModelToCompanyBranchConverter;
import com.impos.company.converters.CompanyBranchToCompanyBranchModelConverter;
import com.impos.company.domain.CompanyBranch;
import com.impos.company.model.CompanyBranchModel;
import com.impos.company.service.ICompanyBranchService;

/*
*@Author varma
*/

@Service

public class CompanyBranchBusinessDelegate
		implements IBusinessDelegate<CompanyBranchModel, CompanyBranchContext, IKeyBuilder<String>, String> {

	@Autowired
	private ICompanyBranchService companyBranchService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private CompanyBranchModelToCompanyBranchConverter tempModelToDomaiConversionService;
	@Autowired
	private CompanyBranchToCompanyBranchModelConverter tempDomainToModelConversionService;

	@Override
	@Transactional
	public CompanyBranchModel create(CompanyBranchModel model) {
		CompanyBranch companyBranch = companyBranchService
				.create((CompanyBranch) tempModelToDomaiConversionService.convert(model));
//		model = convertToCompanyBranchModel(companyBranch);
		model = tempDomainToModelConversionService.convert(companyBranch);
		return model;
	}

	private CompanyBranchModel convertToCompanyBranchModel(CompanyBranch companyBranch) {
		return (CompanyBranchModel) conversionService.convert(companyBranch, forObject(companyBranch),
				valueOf(CompanyBranchModel.class));
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CompanyBranchContext context) {

	}

	@Override
	public CompanyBranchModel edit(IKeyBuilder<String> keyBuilder, CompanyBranchModel model) {
		CompanyBranch companyBranch = companyBranchService.getCompanyBranch(keyBuilder.build().toString());
		companyBranch = companyBranchService
				.updateCompanyBranch((CompanyBranch) tempModelToDomaiConversionService.convert(model));
//		companyBranch = companyBranchService.updateCompanyBranch(
//				(CompanyBranch) conversionService.convert(model, forObject(model), valueOf(CompanyBranch.class)));
		model = tempDomainToModelConversionService.convert(companyBranch);

		return model;
	}

	@Override
	public CompanyBranchModel getByKey(IKeyBuilder<String> keyBuilder, CompanyBranchContext context) {
		CompanyBranch companyBranch = companyBranchService.getCompanyBranch(keyBuilder.build().toString());
		CompanyBranchModel model = conversionService.convert(companyBranch, CompanyBranchModel.class);
		return model;
	}

	@Override
	public Collection<CompanyBranchModel> getCollection(CompanyBranchContext context) {

		List<CompanyBranchModel> companyBranchModels = new ArrayList<>();
		for (CompanyBranch companyBranche : companyBranchService.getAll(context)) {

			companyBranchModels.add(tempDomainToModelConversionService.convert(companyBranche));

		}

//		List<CompanyBranchModel> companyBranchModels = (List<CompanyBranchModel>) conversionService.convert(
//				companyBranch, TypeDescriptor.forObject(companyBranch),
//				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CompanyBranchModel.class)));
		return companyBranchModels;
	}

	@Override
	public CompanyBranchModel edit(IKeyBuilder<String> keyBuilder, CompanyBranchModel model,
			CompanyBranchContext context) {
		return null;
	}

}
