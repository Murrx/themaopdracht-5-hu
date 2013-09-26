package com.th5.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;

@SuppressWarnings("hiding")
public class UserDatabaseCRUD implements CRUD_Interface<User>{

	@Override
	public User retrieve(String identifier) throws AuctifyException {
		
		Connection connection;
		try {
			connection = JDBCService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		
		PreparedStatement statement = null;
		User user = null;

		try{
			statement = connection.prepareStatement("SELECT * FROM usr_users WHERE usr_email = ?");
			statement.setString(1, identifier);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				
				String username = result.getString("usr_email");
				String password = result.getString("usr_password");
				String displayName = result.getString("usr_display_name");
				int userId = result.getInt("usr_pk_user_id");
				UserRights rights = UserRights.fromInteger(result.getInt("usr_right_id"));
				
				user = new User(userId, username, password, displayName, rights);
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
		if (user == null) throw new AuctifyException("user not found");
		return user;
	}

	@Override
	public ArrayList search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(User user) throws AuctifyException {
		
		Connection connection;
		try {
			connection = JDBCService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		
		PreparedStatement statement = null;
		
		try{
			statement = connection.prepareStatement("INSERT INTO usr_users (usr_email, usr_password, usr_display_name, usr_right_id) VALUES(?,?,?,?)");
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getDisplayName());
			statement.setInt(4, user.getRights().getRightsValue());
			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to add user");
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
	}

	@Override
	public void update(User object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User object) {
		// TODO Auto-generated method stub
		
	}
}
