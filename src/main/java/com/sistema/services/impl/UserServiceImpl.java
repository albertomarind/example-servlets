package com.sistema.services.impl;

import java.util.List;

import com.sistema.daos.UserDao;
import com.sistema.daos.impl.UserDaoImpl;
import com.sistema.models.User;
import com.sistema.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDao usuarioDao;

	public UserServiceImpl() {
		this.usuarioDao = new UserDaoImpl();
	}

	@Override
	public User getUserAndRoleByUsernameAndPassword(String username, String password) {
		return usuarioDao.getUserAndRoleByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findAllUsersWithRoles() {
		return usuarioDao.findAllUsersWithRoles();
	}

}
