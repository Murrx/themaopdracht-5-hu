package com.th5.domain.service;

import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;

public interface AuctionServiceInterface {
	public User login(String login_email, String login_password) throws AuctifyException;	
	public void register(String email, String password, String displayName) throws AuctifyException;
}
