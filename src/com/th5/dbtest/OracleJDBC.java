package com.th5.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class OracleJDBC {
 
	public static void main(String[] argv) {
 
		System.out.println("-------- Oracle JDBC Connection Testing ------");
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//ondora01.hu.nl:8521/cursus01.hu.nl","tho5_2013_2a_team5","team5iscool");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}