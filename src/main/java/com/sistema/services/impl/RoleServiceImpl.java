package com.sistema.services.impl;

import java.util.List;

import com.sistema.daos.RoleDao;
import com.sistema.daos.impl.RoleDaoImpl;
import com.sistema.models.Role;
import com.sistema.services.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao = new RoleDaoImpl();

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role save(Role role) {
		return roleDao.save(role);
	}

}
