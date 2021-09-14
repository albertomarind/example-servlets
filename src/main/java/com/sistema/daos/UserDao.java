package com.sistema.daos;

import com.sistema.models.User;

public interface UserDao {

	User getUserAndRoleByUsernameAndPassword(String username, String password);
}
