package com.th5.persistance;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;

public interface CRUD_Interface<T> extends Observer{
	
	   
	   public T retrieve(Object identifier) throws AuctifyException;
	   public List<T> search(String search) throws AuctifyException;
	   public List<T> retrieveAll() throws AuctifyException;
	   public int create(T object) throws AuctifyException;
	   public void update(T object) throws AuctifyException;
	   public void delete(int auctionId) throws AuctifyException;
	}
