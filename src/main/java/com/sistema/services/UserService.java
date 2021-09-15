package com.sistema.services;

import java.util.List;

import com.sistema.models.User;

public interface UserService {
	User getUserAndRoleByUsernameAndPassword(String username, String password);

	List<User> findAllUsersWithRoles();

	User save(User user);

}
