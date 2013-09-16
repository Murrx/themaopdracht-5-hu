package com.th5.persistance;

import com.th5.domain.model.User;

public interface UserDAOInterface{
	   public User login(String username, String password);
	   public boolean contains(String username);
	   public boolean register(String username, String password);
	}
