package de.linus.fibu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection connection;

	public DatabaseConnection(String dbpath, String user, String password) throws SQLException {
		connection = DriverManager.getConnection("jdbc:h2:" + dbpath + ";create=true", user, password);
	}

	public Connection getConnection() {
		return connection;
	}
}