package com.th5.domain.service;

import com.th5.domain.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.UserListManager;

public class AuctionService implements AuctionServiceInterface{

	private UserListManager userList;
	
	public AuctionService(){
		userList = new UserListManager();
	}
	
	private String encryptPassword (String password) {
		return DigestUtils.sha512Hex( password );
	}
	
	@Override
	public User login(String login_email, String login_password) {
		login_password = encryptPassword(login_password);
		User user = userList.retrieve(login_email);
		if (user != null && user.getPassword().equals(login_password)){
			return user;	
		}
		else return null;
	}
	
	@Override
	public boolean register(String email, String password, String displayName) {
		password = encryptPassword(password);
		return userList.create(new User(email, password, displayName, UserRights.USER));
	}
	

}
