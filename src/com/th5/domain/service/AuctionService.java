package com.th5.domain.service;

import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.UserListManager;

public class AuctionService implements AuctionServiceInterface{

	private UserListManager userList;
	
	public AuctionService(){
		userList = new UserListManager();
	}
	
	@Override
	public User login(String login_email, String login_password) throws AuctifyException {
		User user = userList.retrieve(login_email);
		if (user == null || !user.getPassword().equals(login_password)){
			throw new AuctifyException("Username op password incorrect");	
		}
		return user;
	}
	
	@Override
	public void register(String email, String password, String displayName) throws AuctifyException{
		userList.create(new User(email, password, displayName, UserRights.USER));
	}
}
