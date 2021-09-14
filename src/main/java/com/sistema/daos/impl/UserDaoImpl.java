package com.sistema.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistema.daos.UserDao;
import com.sistema.models.Role;
import com.sistema.models.User;
import com.sistema.utils.JdbcConnection;
import com.sistema.utils.Scripts;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		this.connection = JdbcConnection.getConnection();
	}

	@Override
	public User getUserAndRoleByUsernameAndPassword(String username, String password) {
		User user = null;
		try (PreparedStatement preparedStatement = this.connection
				.prepareStatement(Scripts.GET_USER_WITH_ROLE_BY_USERNAME_AND_PASSWORD);) {	
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Role role = new Role(rs.getInt("id_role"), rs.getString("role_description"));
				user = new User(rs.getInt("id_user"), rs.getString("username"), role);
				System.out.println(user);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<User> findAllUsersWithRoles() {
		List<User> users = new ArrayList<>();
		try (PreparedStatement preparedStatement = this.connection
				.prepareStatement(Scripts.GET_ALL_USERS_WITH_ROLES);) {
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Role role = new Role(rs.getInt("id_role"), rs.getString("role_description"));
				User user = new User(rs.getInt("id_user"), rs.getString("username"), role);
				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return users;
	}

}
