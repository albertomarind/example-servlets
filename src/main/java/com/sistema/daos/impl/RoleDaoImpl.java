package com.sistema.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.daos.RoleDao;
import com.sistema.models.Role;
import com.sistema.models.User;
import com.sistema.utils.JdbcConnection;
import com.sistema.utils.Scripts;

public class RoleDaoImpl implements RoleDao {
	private Connection connection;

	public RoleDaoImpl() {
		this.connection = JdbcConnection.getConnection();
	}

	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(Scripts.GET_ALL_ROLES);
				ResultSet rs = preparedStatement.executeQuery()) {
			while (rs.next()) {
				Role role = new Role(rs.getInt("id"), rs.getString("description"));
				roles.add(role);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return roles;
	}

	@Override
	public Role save(Role role) {
		Role roleCreated = new Role();
		roleCreated.setDescription(role.getDescription());
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(Scripts.INSERT_ROLE,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, role.getDescription());
			int roleRowsUpdated = preparedStatement.executeUpdate();
			if (roleRowsUpdated  > 0) {
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					Integer idRole = rs.getInt(1);
					roleCreated.setId(idRole);
				}
				rs.close();
			}
			preparedStatement.close();
			return roleCreated;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} 
	}

}
