package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.th5.domain.model.Address;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;
import com.th5.domain.service.ServiceProvider;

@SuppressWarnings("hiding")
public class UserDatabaseCRUD implements CRUD_Interface<User>, Observer{

	/**Retrieve user from the database
	 * @param email
	 * @return a user object
	 * @throws AuctifyException when the user is not found or when the database connection fails 
	 */
	@Override
	public User retrieve(Object em) throws AuctifyException {
		String email = (String)em;
		Connection connection = DataSourceService.getConnection();

		PreparedStatement statement = null;
		User user = null;
		Address address = null;
		Person person = null;

		try{
			statement = connection.prepareStatement(
					"SELECT * FROM usr_users, prs_persons, adr_addresses WHERE usr_email = ? AND usr_fk_person_id = prs_pk_person_id AND prs_fk_address_id = adr_pk_address_id");
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();

			while(result.next()){

				//user data
				String username = result.getString("usr_email");
				String password = result.getString("usr_password");
				String displayName = result.getString("usr_display_name");
				int userId = result.getInt("usr_pk_user_id");
				UserRights rights = UserRights.fromInteger(result.getInt("usr_fk_right_id"));
				int bidCoins = result.getInt("usr_bidcoins");

				user = new User(userId, username, password, displayName, rights, bidCoins);

				//person data
				int personId = result.getInt("prs_pk_person_id");
				String firstName = result.getString("prs_first_name");
				String lastName = result.getString("prs_last_name");
				int gender = result.getInt("prs_gender");
				java.util.Date birthdate = result.getDate("prs_birthdate");

				person = new Person(personId,firstName, lastName, gender, birthdate);

				//address data
				int addressId = result.getInt("adr_pk_address_id");
				String postalCode = result.getString("adr_postal_code");
				String houseNumber = result.getString("adr_pk_address_id");
				String street = result.getString("adr_street");
				String city = result.getString("adr_city");

				address = new Address(addressId,postalCode, houseNumber, street, city);

				user.setPerson(person);
				user.setAddress(address);
			}

		}catch(SQLException e){
			throw new AuctifyException("failed to retrieve user");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		if (user == null) throw new AuctifyException("user not found");
		return user;
	}

	@Override
	public ArrayList<User> search(String search, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**Add a user to the database
	 * @param user the user to add
	 * @return the id of the created user
	 * @throws AuctifyException when the connection fails, or the user cannot be added
	 */
	@Override
	public int create(User user) throws AuctifyException {

		Connection connection = DataSourceService.getConnection();

		CallableStatement statement = null;

		try{
			String functionCall = "{? = call pkg_user_modification.f_register_user(?,?,?,?,?,?,?,?,?,?,?,?)}";
			statement = connection.prepareCall(functionCall);

			// ---  RETURN  ----- //
			statement.registerOutParameter(1, Types.NUMERIC);

			// --- USR_USERS ---- //

			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getDisplayName());
			statement.setInt(5, user.getBidCoins());


			// --- PRS_PERSONS ---- //
			statement.setString(6, user.getPerson().getFirstName());
			statement.setString(7, user.getPerson().getLastName());
			statement.setInt(8, user.getPerson().getGender());
			statement.setDate(9, DateConverter.dateToSQLDate(user.getPerson().getBirthdate()));

			// --- ADR_ADRESSES ---- //
			statement.setString(10, user.getAddress().getPostalCode());
			statement.setString(11, user.getAddress().getHouseNumber());
			statement.setString(12, user.getAddress().getStreet());
			statement.setString(13, user.getAddress().getCity());

			statement.executeQuery();

			int userId = statement.getInt(1);
			return userId;

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to create user");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
	}

	@Override
	public void update(User object) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();

		PreparedStatement statement = null;

		try{

			statement = connection.prepareCall("{call pkg_user_modification.pr_update_user(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// --- USR_USERS ---- //
			statement.setInt(1, object.getUserId());
			statement.setString(2, object.getEmail());
			statement.setString(3, object.getPassword());
			statement.setString(4, object.getDisplayName());
			statement.setInt(5, object.getBidCoins());

			// --- PRS_PERSONS ---- //
			statement.setString(6, object.getPerson().getFirstName());
			statement.setString(7, object.getPerson().getLastName());
			statement.setInt(8, object.getPerson().getGender());
			statement.setDate(9, DateConverter.dateToSQLDate(object.getPerson().getBirthdate()));

			// --- ADR_ADRESSES ---- //
			statement.setString(10, object.getAddress().getPostalCode());
			statement.setString(11, object.getAddress().getHouseNumber());
			statement.setString(12, object.getAddress().getStreet());
			statement.setString(13, object.getAddress().getCity());

			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException(e.getMessage());
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
	}


	/**Only used for testing. Do not use.
	 * @see com.th5.persistance.CRUD_Interface#delete(java.lang.Object)
	 */@Deprecated
	 @Override
	 public void delete(int userId) throws AuctifyException {
		 Connection connection = DataSourceService.getConnection();
		 User user = ServiceProvider.getService().getUserById(userId);
		 PreparedStatement statement = null;

		 try{

			 statement = connection.prepareCall("{call pkg_user_modification.pr_delete_user(?,?,?,?,?,?,?,?,?,?,?)}");

			 // --- USR_USERS ---- //
			 statement.setString(1, user.getEmail());
			 statement.setString(2, user.getPassword());
			 statement.setString(3, user.getDisplayName());

			 // --- PRS_PERSONS ---- //
			 statement.setString(4, user.getPerson().getFirstName());
			 statement.setString(5, user.getPerson().getLastName());
			 statement.setInt(6, user.getPerson().getGender());
			 statement.setDate(7, DateConverter.dateToSQLDate(user.getPerson().getBirthdate()));

			 // --- ADR_ADRESSES ---- //
			 statement.setString(8, user.getAddress().getPostalCode());
			 statement.setString(9, user.getAddress().getHouseNumber());
			 statement.setString(10, user.getAddress().getStreet());
			 statement.setString(11, user.getAddress().getCity());

			 statement.executeQuery();

		 }catch(SQLException e){
			 e.printStackTrace();
			 throw new AuctifyException("failed to delete user");
		 }finally{
			 DataSourceService.closeConnection(connection, statement);
		 }
	 }

	 @Override
	 public void updateObserver(Object obj) throws AuctifyException {
		 // TODO Auto-generated method stub
		 try {
			 update((User) obj);
		 } catch (AuctifyException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 throw new AuctifyException(e.getMessage());
		 }

	 }

	 @Override
	 public void setObservable(Observable obs) {
		 // TODO Auto-generated method stub
	 }

	 public User retrieveById(int id) throws AuctifyException {
		 Connection connection = DataSourceService.getConnection();

		 PreparedStatement statement = null;
		 User user = null;
		 Address address = null;
		 Person person = null;

		 try{
			 statement = connection.prepareStatement(
					 "SELECT * FROM usr_users, prs_persons, adr_addresses WHERE usr_pk_user_id = ? AND usr_fk_person_id = prs_pk_person_id AND prs_fk_address_id = adr_pk_address_id");
			 statement.setInt(1, id);
			 ResultSet result = statement.executeQuery();

			 while(result.next()){

				 //user data
				 String username = result.getString("usr_email");
				 String password = result.getString("usr_password");
				 String displayName = result.getString("usr_display_name");
				 int userId = result.getInt("usr_pk_user_id");
				 UserRights rights = UserRights.fromInteger(result.getInt("usr_fk_right_id"));
				 int bidCoins = result.getInt("usr_bidcoins");

				 user = new User(userId, username, password, displayName, rights, bidCoins);

				 //person data
				 int personId = result.getInt("prs_pk_person_id");
				 String firstName = result.getString("prs_first_name");
				 String lastName = result.getString("prs_last_name");
				 int gender = result.getInt("prs_gender");
				 java.util.Date birthdate = result.getDate("prs_birthdate");

				 person = new Person(personId,firstName, lastName, gender, birthdate);

				 //address data
				 int addressId = result.getInt("adr_pk_address_id");
				 String postalCode = result.getString("adr_postal_code");
				 String houseNumber = result.getString("adr_pk_address_id");
				 String street = result.getString("adr_street");
				 String city = result.getString("adr_city");

				 address = new Address(addressId,postalCode, houseNumber, street, city);

				 user.setPerson(person);
				 user.setAddress(address);
			 }

		 }catch(SQLException e){
			 e.printStackTrace();
			 throw new AuctifyException (e.getMessage());
		 }finally{
			 DataSourceService.closeConnection(connection, statement);
			 
		 }
		 if (user == null) throw new AuctifyException("user not found");
		 return user;
	 }
}
