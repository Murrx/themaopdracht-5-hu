package com.th5.persistance;

import java.util.List;

import com.th5.domain.other.AuctifyException;

public interface CRUD_Interface<T>{
	
	   public List<T> retrieve(String identifier, String query) throws AuctifyException;
	   public int create(T type) throws AuctifyException;
	   public void update(T type) throws AuctifyException;
	   public void delete(int identifier) throws AuctifyException;
	}
