package com.sistema.daos;

import java.util.List;

import com.sistema.models.User;

public interface UserDao {

	User getUserAndRoleByUsernameAndPassword(String username, String password);

	List<User> findAllUsersWithRoles();
}
