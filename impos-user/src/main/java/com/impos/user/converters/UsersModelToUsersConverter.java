/**
 *
 */
package com.impos.user.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.user.domain.Users;
import com.impos.user.model.UsersModel;

/**
 * @author Jay
 *
 */
@Component("usersModelToUsersConverter")
public class UsersModelToUsersConverter implements Converter<UsersModel, Users> {
    @Autowired
    private ObjectFactory<Users> usersFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Users convert(final UsersModel source) {
        Users users = usersFactory.getObject();
        BeanUtils.copyProperties(source, users);

        return users;
    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<Users> usersFactory) {
        this.usersFactory = usersFactory;
    }

}
