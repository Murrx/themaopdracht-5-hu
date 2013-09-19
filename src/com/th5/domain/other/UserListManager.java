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

	public User getUser(String username, String password){
		User user = null;
		int index = Collections.binarySearch(userList, new User(username, password));
		System.out.println(userList);
		if (!( index < 0)){
			user = userList.get(index);
		}else if (user == null){
			user = userDAO.login(username, password);
			if (user != null) userList.add(user);
		}
		return user;
	}

	public boolean register(String username, String password){
		boolean result = false;
		
		if (!userDAO.contains(username)){
			result = userDAO.register(username, password);
			System.out.println(result);
		}
		return result;
	}
}
