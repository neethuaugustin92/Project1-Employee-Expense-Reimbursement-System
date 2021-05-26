package com.project1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private final String URL = "jdbc:postgresql://database-1.csc4kqssqi0m.us-east-2.rds.amazonaws.com:5432/projectrembersementdb";
	private final String username = "projectrembersementuser";
	private final String password = "Password";
	
	public Connection getDbConnection() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(URL, username, password);
	}






}

/*
public class ConnectionUtil {

	public ConnectionUtil() {
		super();
	}

	private static Connection connection;

	public static Connection getConnection() throws IOException, SQLException, Exception {
		Properties p = new Properties();
		InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("connection.properties");
		p.load(resourceStream);
		Class.forName("org.postgresql.Driver");
		String url = p.getProperty("url");
		System.out.println(url+"url found from properties");
		String username = p.getProperty("user");
		String password = p.getProperty("pwd");
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection done");
		}
		return connection;
	}
*/

