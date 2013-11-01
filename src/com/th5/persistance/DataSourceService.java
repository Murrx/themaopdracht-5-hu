package com.th5.persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

import com.th5.domain.other.AuctifyException;

public class DataSourceService {

	public static Connection getConnection() throws AuctifyException{

		OracleDataSource ds = null;
		try {
			ds = new OracleDataSource();

			ds.setDriverType("thin");
			ds.setServerName("ondora01.hu.nl");
			ds.setServiceName("cursus01.hu.nl");
			ds.setNetworkProtocol("tcp");
			ds.setDatabaseName("tho5_2013_2a_team5");
			ds.setPortNumber(8521);
			ds.setUser("tho5_2013_2a_team5");
			ds.setPassword("team5iscool");

			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database: "+e.getMessage());
			e.printStackTrace();
			throw new AuctifyException("failed to connect to database");
		}
	}
	public static void closeConnection(Connection connection, Statement statement){
		try {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


