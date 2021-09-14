package com.sistema.services;

import com.sistema.models.User;

public interface UserService {
	User getUserAndRoleByUsernameAndPassword(String username, String password);

}
