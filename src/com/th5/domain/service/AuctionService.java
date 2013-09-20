package com.th5.domain.service;

import com.th5.domain.model.User;
import com.th5.domain.other.UserListManager;

public class AuctionService implements AuctionServiceInterface{

	private UserListManager userList;
	
	public AuctionService(){
		userList = new UserListManager();
	}
	
	@Override
	public User login(String login_email, String login_password) {
		User user = userList.retrieve(login_email);
		if (user != null && user.getPassword().equals(login_password)){
			return user;	
		}
		else return null;
	}
	
	@Override
	public boolean register(String email, String password) {
		return userList.create(new User(email, password));
	}
	

}
