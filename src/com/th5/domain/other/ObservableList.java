package com.th5.domain.other;

import java.util.ArrayList;
import com.th5.domain.model.*;

import com.th5.persistance.UserDAOInterface;
import com.th5.persistance.UserDao;

@SuppressWarnings("hiding")
public class ObservableList extends ArrayList<User> {

	UserDAOInterface userDAO = new UserDao();

	public User getUser(String username, String password){
		for(User user : this){
			if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())){
				System.out.println("Found user in list");
				return user;
			}
		}
		User user = userDAO.login(username, password);
		if (user != null)
			this.add(user);
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
