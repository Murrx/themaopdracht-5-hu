package com.th5.domain.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.th5.domain.model.User;
import com.th5.persistance.UserDAOInterface;
import com.th5.persistance.UserDao;

@SuppressWarnings("hiding")
public class UserListManager{

	List<User> userList;
	UserDAOInterface userDAO;
	
	public UserListManager(){
		userDAO  = new UserDao();
		userList = new SortedArrayList<User>();
	}

	public User getUser(String login_email, String login_password){
		User user = null;
		int index = Collections.binarySearch(userList, new User(login_email, login_password));
		System.out.println(userList);
		if (!( index < 0)){
			user = userList.get(index);
		}else if (user == null){
			user = userDAO.login(login_email, login_password);
			if (user != null) userList.add(user);
		}
		return user;
	}

	public boolean register(String email, String password){
		boolean result = false;
		
		if (!userDAO.contains(email)){
			result = userDAO.register(email, password);
			if (result)userList.add(new User(email, password));
		}
		return result;
	}
}
