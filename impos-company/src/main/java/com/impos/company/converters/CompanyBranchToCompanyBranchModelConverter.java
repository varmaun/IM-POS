package com.impos.company.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.company.domain.CompanyBranch;
import com.impos.company.model.CompanyBranchModel;

@Component("companyBranchToCompanyBranchModelConverter")
public class CompanyBranchToCompanyBranchModelConverter
        implements Converter<CompanyBranch, CompanyBranchModel> {
    @Autowired
    private ObjectFactory<CompanyBranchModel> companyBranchModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
	public CompanyBranchModel convert(final CompanyBranch source) {
        CompanyBranchModel companyBranchModel = companyBranchModelFactory.getObject();
        BeanUtils.copyProperties(source, companyBranchModel);

        return companyBranchModel;
    }

    @Autowired
    public void setCompanyBranchModelFactory(
            final ObjectFactory<CompanyBranchModel> companyBranchModelFactory) {
        this.companyBranchModelFactory = companyBranchModelFactory;
    }
}
