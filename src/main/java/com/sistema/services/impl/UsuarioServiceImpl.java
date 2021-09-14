package com.sistema.services.impl;

import com.sistema.daos.UsuarioDao;
import com.sistema.daos.impl.UsuarioDaoImpl;
import com.sistema.models.Usuario;
import com.sistema.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDao usuarioDao;

	public UsuarioServiceImpl() {
		this.usuarioDao = new UsuarioDaoImpl();
	}

	@Override
	public Usuario isUserInDatabase(String username, String password) {
		return usuarioDao.isUserInDatabase(username, password);
	}

}
