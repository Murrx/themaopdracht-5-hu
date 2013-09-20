package com.th5.domain.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.th5.domain.model.User;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.UserCRUD;

@SuppressWarnings("hiding")
public class UserListManager{

	List<User> userList;
	CRUD_Interface<User> userCRUD;
	
	public UserListManager(){
		userList = new SortedArrayList<User>();
		userCRUD = new UserCRUD();
	}

	public User userLogin(String login_email, String login_password){
		User user = null;
		int index = Collections.binarySearch(userList, new User(login_email, login_password));
		System.out.println(userList);
		if (!( index < 0)){
			user = userList.get(index);
		}else if (user == null){
			user = userCRUD.retrieve(login_email);
			
			if (user != null && user.getPassword().equals(login_password)) userList.add(user);
			else user = null;
		}
		return user;
	}

	public boolean register(String email, String password){
		boolean result = false;
		
		if (userCRUD.retrieve(email) == null){
			result = userCRUD.create(new User(email, password));
			if (result)userList.add(new User(email, password));
		}
		return result;
	}
}
