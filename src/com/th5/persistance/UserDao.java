package com.th5.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.crypto.provider.RSACipher;
import com.th5.domain.model.User;

public class UserDao implements UserDAOInterface{

	@Override
	public User login(String email, String password) {
		Connection connection = JDBCService.getConnection();
		PreparedStatement statement = null;
		User user = null;

		try{
			statement = connection.prepareStatement("SELECT * FROM usr_users WHERE usr_email = ? AND usr_password = ?");
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				
				String uname = result.getString("usr_username");
				String pw = result.getString("usr_password");
				
				user = new User(uname, pw);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public boolean contains(String email) {
		Connection connection = JDBCService.getConnection();
		PreparedStatement statement = null;
		boolean result = false;
		
		try{
			statement = connection.prepareStatement("SELECT * FROM usr_users WHERE usr_email = ?");
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()){
				String resEmail = resultSet.getString("usr_email");
				result = email.equals(resEmail);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public boolean register(String email, String password) {
		Connection connection = JDBCService.getConnection();
		PreparedStatement statement = null;
		boolean result = true;
		
		try{
			statement = connection.prepareStatement("INSERT INTO usr_users (usr_email, usr_password) VALUES(?,?)");
			statement.setString(1, email);
			statement.setString(2, password);
			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			result = false;
		}finally{
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

}
