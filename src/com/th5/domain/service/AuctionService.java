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
		return userList.userLogin(login_email,login_password);
	}
	
	@Override
	public boolean register(String email, String password) {
		return userList.register(email, password);
	}
	

}
