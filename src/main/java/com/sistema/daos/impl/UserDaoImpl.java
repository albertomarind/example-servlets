package com.sistema.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			while (rs.next()) {
				Role role = new Role(rs.getInt("id_role"), rs.getString("role_description"));
				User user = new User(rs.getInt("id_user"), rs.getString("username"), role);
				System.out.println("aqui -> " + user.getUsername());
				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		for (User user2 : users) {
			System.out.println("el for-> " + user2.getUsername());
		}

		return users;
	}

	@Override
	public User save(User user) {
		User userCreated = new User();
		userCreated.setUsername(user.getUsername());
		userCreated.setPassword(user.getPassword());
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmUser = this.connection.prepareStatement(Scripts.INSERT_USER,
					Statement.RETURN_GENERATED_KEYS);
			pstmUser.setString(1, user.getUsername());
			pstmUser.setString(2, user.getPassword());
			int userRowsUpdated = pstmUser.executeUpdate();
			if (userRowsUpdated > 0) {
				ResultSet rs = pstmUser.getGeneratedKeys();
				if (rs.next()) {
					Integer idUser = rs.getInt(1);
					userCreated.setId(idUser);
					PreparedStatement pstmUsersRoles = this.connection.prepareStatement(Scripts.INSERT_USERS_ROLES);
					pstmUsersRoles.setInt(1, idUser);
					pstmUsersRoles.setInt(2, user.getRole().getId());
					int usersRolesRowsUpdated = pstmUsersRoles.executeUpdate();
					if (usersRolesRowsUpdated > 0) {
						connection.commit();
					}
					pstmUsersRoles.close();
				}
				rs.close();
			}
			pstmUser.close();
			return userCreated;
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			return null;
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
