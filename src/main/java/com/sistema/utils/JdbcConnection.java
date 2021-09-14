package com.sistema.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/sistema", "alberto", "sasa");
				return connection;
			} catch (SQLException sqle) {
				System.out.println(sqle);
				return null;
			}
		} else {
			return connection;
		}
	}

}
