package com.impos.user.service;

import java.util.List;

import com.impos.user.businessdelegate.context.UsersContext;
import com.impos.user.domain.Users;

/*
*@Author varma
*/
public interface IUsersService {

	Users create(Users users);

	void deleteUsers(String usersId);

	Users getUsers(String usersId);

	List<Users> getAll(UsersContext context);

	Users updateUsers(Users users);
}
