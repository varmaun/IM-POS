package com.impos.company.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.model.CompanyBranchUsersModel;

@Component("companyBranchUsersToCompanyBranchUsersModelConverter")
public class CompanyBranchUsersToCompanyBranchUsersModelConverter
        implements Converter<CompanyBranchUsers, CompanyBranchUsersModel> {
    @Autowired
    private ObjectFactory<CompanyBranchUsersModel> companyBranchUsersModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CompanyBranchUsersModel convert(final CompanyBranchUsers source) {
        CompanyBranchUsersModel companyBranchUsersModel = companyBranchUsersModelFactory.getObject();
        BeanUtils.copyProperties(source, companyBranchUsersModel);

        return companyBranchUsersModel;
    }

    @Autowired
    public void setCompanyBranchUsersModelFactory(
            final ObjectFactory<CompanyBranchUsersModel> companyBranchUsersModelFactory) {
        this.companyBranchUsersModelFactory = companyBranchUsersModelFactory;
    }
}
