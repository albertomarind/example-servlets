package com.sistema.daos;

import java.util.List;

import com.sistema.models.Role;

public interface RoleDao {
	List<Role> findAll();
	Role save(Role role);
}
