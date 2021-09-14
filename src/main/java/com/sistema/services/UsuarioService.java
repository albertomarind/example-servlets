package com.sistema.services;

import com.sistema.models.Usuario;

public interface UsuarioService {
	Usuario isUserInDatabase(String username, String password);

}
