package com.th5.persistance;

import com.th5.domain.model.User;

public interface UserDAOInterface{
	   public User login(String email, String password);
	   public boolean contains(String email);
	   public boolean register(String email, String password);
	}
