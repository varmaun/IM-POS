package com.impos.company.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.company.businessdelegate.context.CompanyContext;
import com.impos.company.converters.CompanyModelToCompanyConverter;
import com.impos.company.converters.CompanyToCompanyModelConverter;
import com.impos.company.domain.Company;
import com.impos.company.model.CompanyModel;
import com.impos.company.service.ICompanyService;

@Service
public class CompanyBusinessDelegate
		implements IBusinessDelegate<CompanyModel, CompanyContext, IKeyBuilder<String>, String> {
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private CompanyModelToCompanyConverter tempCompanyModelToCompanyConverter;
	@Autowired
	private CompanyToCompanyModelConverter tempComanyToCompanyModelConverter;

	@Override
	public CompanyModel create(CompanyModel model) {

//		Company company = new Company();
//		conversionService.convert(model, Department.class);
//		converter(model, company);

		model = tempComanyToCompanyModelConverter
				.convert(companyService.create(tempCompanyModelToCompanyConverter.convert(model)));

		/*
		 * Department department = departmentService.create((Department)
		 * conversionService .convert(model, forObject(model),
		 * valueOf(Department.class)));
		 */

//		Department department = new Department();
//		converter(model, department);
//		departmentService.create(department);

		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CompanyContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public CompanyModel edit(IKeyBuilder<String> keyBuilder, CompanyModel model) {

		if (model != null && model.getId() != null) {
			Company company = new Company();
			converter(model, company);
			companyService.updateCompany(company);
			converter(company, model);
		}
		return model;
	}

	@Override
	public CompanyModel edit(IKeyBuilder<String> keyBuilder, CompanyModel model, CompanyContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyModel getByKey(IKeyBuilder<String> keyBuilder, CompanyContext context) {
		Company company = companyService.getCompany(keyBuilder.build().toString());
		CompanyModel model = new CompanyModel();
		converter(company, model);
		return model;
	}

	@Override
	public Collection<CompanyModel> getCollection(CompanyContext context) {
		List<CompanyModel> models = new ArrayList<CompanyModel>();
		for (Company company : companyService.getAll(context)) {
			CompanyModel model = new CompanyModel();
			converter(company, model);
			models.add(model);
		}
		return models;
	}

	private void converter(Company source, CompanyModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(CompanyModel source, Company target) {

		BeanUtils.copyProperties(source, target);
	}
}
