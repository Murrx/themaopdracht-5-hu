package com.th5.domain.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.UserDatabaseCRUD;
import com.th5.persistance.queries.Queries;

@SuppressWarnings("hiding")
public class UserListManager{

	private List<User> userList;
	private UserDatabaseCRUD userDatabaseCRUD;

	public UserListManager(){
		userList = new SortedArrayList<User>();
		userDatabaseCRUD = new UserDatabaseCRUD();
	}

	/**
	 * Attempt to create user
	 * Attempts to create user. If the email address is not already in use, the user
	 * is created and added to the list and the database.
	 * 
	 * @param user User object to be created
	 * @return the id of the created user
	 * @throws AuctifyException when the email address of the user is used by another user.
	 */
	public int create(User user) throws AuctifyException{
		if (!emailAvailable(user.getEmail())){
			throw new AuctifyException("Email adress is already in use");
		}

		int userId = -1;

		try {
			userId = userDatabaseCRUD.create(user);
			user.setUserId(userId);
			userList.add(user);
		} catch (AuctifyException ae) {
			throw new AuctifyException(ae.getMessage());
		}
		return userId;
	}

	/**
	 * Attempt to retrieve user
	 * First attempt to retrieve user from userlist
	 * If that fails it attempts to retrieve use from database
	 * 
	 * @param email identifier of user to retrieve
	 * @return the retrieved user
	 * @throws AuctifyException when the user is not found
	 */
	public User retrieve(Object em) throws AuctifyException{
		String email = (String)em;
		User user = getUserFromUserList(email);
		if (user == null){
			List<User> result = userDatabaseCRUD.retrieve(email,Queries.selectUserByEmail);
			user = result.get(0);
			if (user != null) userList.add(user);
			else throw new AuctifyException("user not found");
		}
		return user;
	}

	/**
	 * Attempt to retrieve user by userId
	 * First attempt to retrieve user from userlist
	 * If that fails it attempts to retrieve use from database
	 * 
	 * @param id of the user to retrieve
	 * @return the retrieved user
	 * @throws AuctifyException when the user is not found
	 */
	public User retrieveById(String identifier) throws AuctifyException{
		//TODO: Check if the user is already in the userList, before querying the db
		List<User> result = userDatabaseCRUD.retrieve(identifier, Queries.selectUserById);
		if (result.isEmpty()) throw new AuctifyException("user not found");
		return result.get(0);
	}
	/**
	 * Attempt to get a user from userList
	 * @param email
	 * @return the user. returns null when user is not found
	 */
	private User getUserFromUserList(String email){
		User user = null;
		int index = Collections.binarySearch(userList, new User(email));
		if ( index >= 0){
			user = userList.get(index);
		}
		return user;
	}	
	
	/**
	 * Attempt to get a user from userList by id
	 * @param id
	 * @return the user. returns null when user is not found
	 */
	public User getUserFromUserList(int id){
		User user = null;
		Iterator<User> it = userList.iterator();
		while(it.hasNext()) {
			User itUser = it.next();
			if(itUser.getUserId() == id) {
				user = itUser;
			}
		}
		return user;
	}
	
	/**
	 * Attempt to get a user from userList by idd
	 * @param userId
	 * @return the user. returns null when user is not found
	 */
	public User getUserFromUserListById(int userId){
		User user = null;
		int index = Collections.binarySearch(userList, new User(userId));
		if ( index >= 0){
			user = userList.get(index);
		}
		return user;
	}

	/**
	 * check if a given email is available to use
	 * @param email
	 * @return true if the email is available
	 * @throws AuctifyException 
	 */
	private boolean emailAvailable(String email) throws AuctifyException{
		List<User> result = userDatabaseCRUD.retrieve(email,Queries.selectUserByEmail);
		return result.isEmpty();
	}
}
