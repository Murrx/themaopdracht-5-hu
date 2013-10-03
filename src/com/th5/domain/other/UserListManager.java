package com.th5.domain.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.th5.domain.model.User;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.UserDatabaseCRUD;

@SuppressWarnings("hiding")
public class UserListManager implements CRUD_Interface<User>{

	private List<User> userList;
	private CRUD_Interface<User> userDatabaseCRUD;

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
	@Override
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
	@Override
	public User retrieve(String email) throws AuctifyException{
		User user = getUserFromUserList(email);
		if (user == null){
			user = userDatabaseCRUD.retrieve(email);
			if (user != null) userList.add(user);
			else throw new AuctifyException("user not found");
		}
		return user;
	}
	
	
	/**
	 * Attempt to get a user from userList
	 * @param email
	 * @return the user. returns null when user is not found
	 */
	private User getUserFromUserList(String email){
		User user = null;
		int index = Collections.binarySearch(userList, new User(email));
		System.out.println(userList);
		if ( index >= 0){
			user = userList.get(index);
		}
		return user;
	}

	/**
	 * check if a given email is available to use
	 * @param email
	 * @return true if the email is available
	 */
	private boolean emailAvailable(String email){
		boolean emailAvailable = true;
		try {
			userDatabaseCRUD.retrieve(email);
			emailAvailable = false;
		} catch (AuctifyException e) {}
		return emailAvailable;
	}

	//Uninplemented methods
	public ArrayList<User> search(String search) {System.out.println("Not implemented");return null;}
	public ArrayList<User> retrieveAll() {System.out.println("Not implemented");return null;}
	public void update(User object) {System.out.println("Not implemented");}
	public void delete(User object){System.out.println("Not implemented");}
}