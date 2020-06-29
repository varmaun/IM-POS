package com.impos.user.businessdelegate;

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
import com.impos.user.businessdelegate.context.UsersContext;
import com.impos.user.converters.UsersModelToUsersConverter;
import com.impos.user.converters.UsersToUsersModelConverter;
import com.impos.user.domain.Users;
import com.impos.user.model.UsersModel;
import com.impos.user.service.IUsersService;

/*
*@Author varma
*/

@Service

public class UsersBusinessDelegate
		implements IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> {

	@Autowired
	private IUsersService usersService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private UsersModelToUsersConverter tempUsersModelToUsersConverter;
	@Autowired
	private UsersToUsersModelConverter tempUsersToIUsersModelConverter;

	@Override
	@Transactional
	public UsersModel create(UsersModel model) {

model= tempUsersToIUsersModelConverter.convert(usersService.create(tempUsersModelToUsersConverter.convert(model)));
		return model;
	}
	
	private UsersModel convertToUsersModel(
			Users users) {
		return (UsersModel) conversionService.convert(
				users, forObject(users),
				valueOf(UsersModel.class));
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, UsersContext context) {

	}

	@Override
	public UsersModel edit(IKeyBuilder<String> keyBuilder, UsersModel model) {
		Users users = usersService.getUsers(keyBuilder.build().toString());
		
		
		model = tempUsersToIUsersModelConverter.convert(usersService.create(tempUsersModelToUsersConverter.convert(model)));
		
		return model;
	}

	@Override
	public UsersModel getByKey(IKeyBuilder<String> keyBuilder, UsersContext context) {
		Users users = usersService.getUsers(keyBuilder.build().toString());
		UsersModel model = tempUsersToIUsersModelConverter.convert(users);
		return model;
	}

	@Override
	public Collection<UsersModel> getCollection(UsersContext context) {
		List<UsersModel> usersModels = new ArrayList<UsersModel>();
		
		
		for(Users users: usersService.getAll(context)){
		usersModels.add(tempUsersToIUsersModelConverter.convert(users));
		}
		
		
		return usersModels;
	}

@Override
	public UsersModel edit(IKeyBuilder<String> keyBuilder, UsersModel model, UsersContext context) {
		return null;
	}



}
