package com.impos.user.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.user.domain.Users;
import com.impos.user.model.UsersModel;

@Component("usersToUsersModelConverter")
public class UsersToUsersModelConverter
        implements Converter<Users, UsersModel> {
    @Autowired
    private ObjectFactory<UsersModel> usersModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersModel convert(final Users source) {
        UsersModel usersModel = usersModelFactory.getObject();
        BeanUtils.copyProperties(source, usersModel);

        return usersModel;
    }

    @Autowired
    public void setUsersModelFactory(
            final ObjectFactory<UsersModel> usersModelFactory) {
        this.usersModelFactory = usersModelFactory;
    }
}
