package com.th5.persistance;

import java.util.List;

import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;

public interface CRUD_Interface<T>{
	
	   public List<T> retrieve(String identifier, String query) throws AuctifyException;
	   public int create(T object) throws AuctifyException;
	   public void update(T object) throws AuctifyException;
	   public void delete(int auctionId) throws AuctifyException;
	}
