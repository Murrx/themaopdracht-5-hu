package com.th5.domain.service;

import com.th5.domain.model.User;

public interface AuctionServiceInterface {
	public User login(String login_email, String login_password);	
	public boolean register(String email, String password, String displayName);
}
