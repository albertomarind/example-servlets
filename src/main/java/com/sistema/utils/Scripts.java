package com.sistema.utils;

public class Scripts {
	public static final String GET_USER_WITH_ROLE_BY_USERNAME_AND_PASSWORD = ""
			+ "SELECT u.id id_user, u.username, cr.id id_role, cr.description role_description FROM users u "
			+ "INNER JOIN users_roles ur ON u.id = ur.id_user "
			+ "INNER JOIN cat_roles cr ON ur.id_role = cr.id "
			+ "WHERE u.username = ? AND u.password = ?";
	public static final String GET_ALL_USERS_WITH_ROLES= ""
			+ "SELECT u.id id_user, u.username, cr.id id_role, cr.description role_description FROM users u "
			+ "INNER JOIN users_roles ur ON u.id = ur.id_user "
			+ "INNER JOIN cat_roles cr ON ur.id_role = cr.id";
	public static final String INSERT_USER= ""
			+ "INSERT INTO users (username,password) VALUES(?,?)";
	public static final String INSERT_USERS_ROLES=""
			+ "INSERT INTO users_roles(id_user,id_role) VALUES(?,?);";
	public static final String GET_ALL_ROLES = ""
			+ "SELECT id,description FROM cat_roles";
	public static final String INSERT_ROLE= ""
			+ "INSERT INTO cat_roles (description) VALUES(?)";
	

}
