package com.th5.service;

import com.th5.domain.User;
import com.th5.persistance.UserDao;

public class AuctionService implements AuctionServiceInterface{

	@Override
	public String login(String username, String password) {
		
		UserDao uDao = new UserDao();

		User user = uDao.login(username, password);

		if (user != null){
			username = user.getUsername();
			return "success";
		}
		else return "error";
	}
	

}
