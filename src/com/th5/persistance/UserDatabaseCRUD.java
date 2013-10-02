package com.th5.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;

@SuppressWarnings("hiding")
public class UserDatabaseCRUD implements CRUD_Interface<User>{

	/**Attempt to retrieve the user from the database
	 * @param email
	 * @return a user object
	 * @throws AuctifyException when the user is not found or when the database connection fails 
	 */
	@Override
	public User retrieve(String email) throws AuctifyException {
		
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
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				
				String username = result.getString("usr_email");
				String password = result.getString("usr_password");
				String displayName = result.getString("usr_display_name");
				int userId = result.getInt("usr_pk_user_id");
				UserRights rights = UserRights.fromInteger(result.getInt("usr_fk_right_id"));
				
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
			
			statement = connection.prepareCall("{call pkg_user_modification.pr_register_user(?,?,?,?,?,?,?,?,?,?,?)}");
			
			// --- USR_USERS ---- //
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getDisplayName());
			
			// --- PRS_PERSONS ---- //
			statement.setString(4, user.getPerson().getFirstName());
			statement.setString(5, user.getPerson().getLastName());
			statement.setInt(6, user.getPerson().getGender());
			statement.setDate(7, DateConverter.toSQLDate(user.getPerson().getBirthdate()));
			System.out.println("UserDatabvaseCRUD without conversion :: " + user.getPerson().getBirthdate());
			System.out.println("UserDatabaseCRUD with conversion :: " + DateConverter.toSQLDate(user.getPerson().getBirthdate()));
			
			// --- ADR_ADRESSES ---- //
			statement.setString(8, user.getAddress().getPostalCode());
			statement.setString(9, user.getAddress().getHouseNumber());
			statement.setString(10, user.getAddress().getStreet());
			statement.setString(11, user.getAddress().getCity());
						
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
