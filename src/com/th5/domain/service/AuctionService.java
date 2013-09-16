package com.th5.domain.service;

import java.util.List;

import com.th5.domain.model.User;
import com.th5.domain.other.ObservableList;
import com.th5.persistance.UserDao;

public class AuctionService implements AuctionServiceInterface{

	private ObservableList userList;
	
	public AuctionService(){
		userList = new ObservableList();
	}
	
	@Override
	public User login(String username, String password) {
		return userList.getUser(username,password);
	}
	
	@Override
	public boolean register(String username, String password) {
		return userList.register(username, password);
	}
	

}
