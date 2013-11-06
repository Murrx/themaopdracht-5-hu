package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.th5.domain.model.Address;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.queries.Queries;

@SuppressWarnings("hiding")
public class UserDatabaseCRUD implements CRUD_Interface<User>, Observer {

	public static int generateId() throws AuctifyException {
		System.out.println("Checkpoint reached UserDatabaseCrud");
		Connection connection = DataSourceService.getConnection();
		CallableStatement statement = null;

		try {
			statement = connection.prepareCall(Queries.generateUserId);
			statement.registerOutParameter(1, Types.NUMERIC);
			statement.executeQuery();

			return statement.getInt(1); 

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("UserDatabaseCRUD.generateId()::failed to generate new user ID");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
	}

	@Override
	public List<User> retrieve(String identifier, String query) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		List<User> userList = new ArrayList<User>();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(query);
			try {
				if (identifier != null) {
					statement.setInt(1, Integer.parseInt(identifier));
				}
			} catch (NumberFormatException e) {
				if (identifier != null) {
					statement.setString(1, identifier);
				}
			}

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				User user = null;
				Address address = null;
				Person person = null;
				// user data
				String username = result.getString("usr_email");
				String password = result.getString("usr_password");
				String displayName = result.getString("usr_display_name");
				int userId = result.getInt("usr_pk_user_id");
				UserRights rights = UserRights.fromInteger(result.getInt("usr_fk_right_id"));
				int bidCoins = result.getInt("usr_bidcoins");

				user = new User(userId, username, password, displayName, rights, bidCoins);

				try{
				// person data
				int personId = result.getInt("prs_pk_person_id");
				String firstName = result.getString("prs_first_name");
				String lastName = result.getString("prs_last_name");
				int gender = result.getInt("prs_gender");
				java.util.Date birthdate = result.getDate("prs_birthdate");

				person = new Person(personId, firstName, lastName, gender, birthdate);

				// address data
				int addressId = result.getInt("adr_pk_address_id");
				String postalCode = result.getString("adr_postal_code");
				String houseNumber = result.getString("adr_house_number");
				String street = result.getString("adr_street");
				String city = result.getString("adr_city");

				address = new Address(addressId, postalCode, houseNumber, street, city);

				user.setPerson(person);
				user.setAddress(address);
				}
				catch(SQLException e){
					// do nothing
				}

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("failed to retrieve user");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
		return userList;
	}

	@Override
	public void create(User user) throws AuctifyException {

		Connection connection = DataSourceService.getConnection();

		CallableStatement statement = null;

		try {
			String functionCall = "{call pkg_user_modification.pr_register_user(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			statement = connection.prepareCall(functionCall);

			statement.setInt(1, user.getUserId());
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

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("UserDatabaseCRUD.create()::failed to create user");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
	}

	@Override
	public void update(User object) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();

		PreparedStatement statement = null;

		try {
			
			statement = connection.prepareCall("{call pkg_user_modification.pr_update_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// --- USR_USERS ---- //
			statement.setInt(1, object.getUserId());
			statement.setString(2, object.getEmail());
			statement.setString(3, object.getPassword());
			statement.setString(4, object.getDisplayName());
			statement.setInt(5, object.getBidCoins());
			statement.setInt(6, object.getRights().getRightsValue());
			// --- PRS_PERSONS ---- //
			statement.setString(7, object.getPerson().getFirstName());
			statement.setString(8, object.getPerson().getLastName());
			statement.setInt(9, object.getPerson().getGender());
			statement.setDate(10, DateConverter.dateToSQLDate(object.getPerson().getBirthdate()));

			// --- ADR_ADRESSES ---- //
			statement.setString(11, object.getAddress().getPostalCode());
			statement.setString(12, object.getAddress().getHouseNumber());
			statement.setString(13, object.getAddress().getStreet());
			statement.setString(14, object.getAddress().getCity());

			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException(e.getMessage());
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
	}

	@Override
	public void delete(int userId) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		User user = ServiceProvider.getService().getUserById(Integer.toString(userId));
		PreparedStatement statement = null;

		try {

			statement = connection.prepareCall("{call pkg_user_modification.pr_delete_user(?,?,?)}");
			
			// --- USR_USERS ---- //
			statement.setInt(1, user.getUserId());

			// --- PRS_PERSONS ---- //
			statement.setInt(2, user.getPerson().getId());

			// --- ADR_ADRESSES ---- //
			statement.setInt(3, user.getAddress().getId());

			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("failed to delete user");
		} finally {
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
}
