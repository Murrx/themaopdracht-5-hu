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

	@Override
	public void create(User user) throws AuctifyException{
		if (!emailAvailable(user.getEmail())){
			throw new AuctifyException("Email adress is already in use");
		}
		userDatabaseCRUD.create(user);
		userList.add(user);
	}

	@Override
	public User retrieve(String login_email) throws AuctifyException{
		User user = getUserFromList(login_email);
		if (user == null){
			user = userDatabaseCRUD.retrieve(login_email);
			if (user != null) userList.add(user);
			else throw new AuctifyException("user not found");
		}
		return user;
	}
	private User getUserFromList(String login_email){
		User user = null;
		int index = Collections.binarySearch(userList, new User(login_email));
		System.out.println(userList);
		if ( index >= 0){
			user = userList.get(index);
		}
		return user;
	}

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