package com.impos.company.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.company.domain.Company;
import com.impos.company.model.CompanyModel;

@Component("companyToCompanyModelConverter")
//@TypeConverter
public class CompanyToCompanyModelConverter implements Converter<Company, CompanyModel> {

	@Autowired
	private ObjectFactory<CompanyModel> companyModelFactory;
	@Autowired
	private ConversionService conversionService;

	@Override
	public CompanyModel convert(Company source) {

		CompanyModel target = companyModelFactory.getObject();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	@Autowired
	public void setCompanyModelFactory(final ObjectFactory<CompanyModel> companyModelFactory) {
		this.companyModelFactory = companyModelFactory;
	}

}
