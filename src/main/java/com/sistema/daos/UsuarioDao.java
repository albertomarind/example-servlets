package com.sistema.daos;

import com.sistema.models.Usuario;

public interface UsuarioDao {
	Usuario isUserInDatabase(String username, String password);
}
