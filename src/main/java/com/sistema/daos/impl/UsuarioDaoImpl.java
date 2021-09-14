package com.sistema.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sistema.daos.Conexion;
import com.sistema.daos.UsuarioDao;
import com.sistema.models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private Connection connection;

	public UsuarioDaoImpl() {
		this.connection = Conexion.getConnection();
	}

	@Override
	public Usuario isUserInDatabase(String username, String password) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = this.connection
					.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.printf("%d %s %s", rs.getInt(1), rs.getString(2), rs.getString(3));
				return new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
