package com.th5.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import oracle.jdbc.pool.OracleDataSource;

public class DataSourceService {

  public static void main(String args[]) throws ClassNotFoundException,
      SQLException, NamingException {

	OracleDataSource ds = new OracleDataSource();
    ds.setDriverType("thin");
	ds.setServerName("ondora01.hu.nl");
	ds.setServiceName("cursus01.hu.nl");
	ds.setNetworkProtocol("tcp");
	ds.setDatabaseName("tho5_2013_2a_team5");
	ds.setPortNumber(8521);
	ds.setUser("tho5_2013_2a_team5");
	ds.setPassword("team5iscool");
	
//	Context ctx = new InitialContext();
//	try {
//		ctx.bind("jdbc/auctifydb", ds);
//	} catch (NamingException e) {
//		e.printStackTrace();
//	}

    Connection conn = ds.getConnection();

    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery("select 'Hello Thin driver data source tester '||" + "initcap(USER)||'!' result from dual");
    if (rset.next())
      System.out.println(rset.getString(1));
    rset.close();
    stmt.close();
    conn.close();
  }
}

