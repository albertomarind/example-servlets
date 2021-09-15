package com.sistema.services;

import java.util.List;

import com.sistema.models.Role;

public interface RoleService {
	List<Role> findAll();
	Role save(Role role);
}
