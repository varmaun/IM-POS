package com.impos.user.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.user.businessdelegate.context.UsersContext;
import com.impos.user.domain.Users;
import com.impos.user.repository.UsersRepository;

/*
*@Author varma
*/
@Component
public class UsersService implements IUsersService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users create(Users users) {

		return usersRepository.save(users);
	}

	@Override
	public void deleteUsers(String usersId) {

	}

	@Override
	public Users getUsers(String usersId) {

		return usersRepository.findById(usersId).orElse(null);
	}

	@Override
	public List<Users> getAll(UsersContext context) {
		List<Users> users = (List<Users>) usersRepository.findAll();

		return users;
	}

	@Override
	public Users updateUsers(Users users) {
		Users userss = getUsers(users.getId());
		try {
			nonNullBeanUtiles.copyProperties(userss, users);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return usersRepository.save(userss);
	}

}
