package com.th5.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.th5.domain.other.AuctifyException;

public class JDBCService {
	
	public static Connection getConnection() throws SQLException{

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@//ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team5", "team5iscool");
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			throw e;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
			throw new SQLException("Failed to make connection!");
		}
	}

}