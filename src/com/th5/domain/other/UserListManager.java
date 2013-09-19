package com.th5.domain.other;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.model.User;
import com.th5.persistance.UserDAOInterface;
import com.th5.persistance.UserDao;

@SuppressWarnings("hiding")
public class UserListManager{

	List<User> userList;
	UserDAOInterface userDAO;
	
	public UserListManager(){
		userList = new ArrayList<User>();
		userDAO  = new UserDao();
	}

	public User getUser(String username, String password){
		for(User user : userList){
			if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())){
				System.out.println("Found user in list");
				return user;
			}
		}
		User user = userDAO.login(username, password);
		if (user != null)
			userList.add(user);
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
