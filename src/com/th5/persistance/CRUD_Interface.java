package com.th5.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;

public interface CRUD_Interface<T>{
	
	   
	   public T retrieve(String identifier) throws AuctifyException;
	   public ArrayList<T> search(String search) throws AuctifyException;
	   public ArrayList<T> retrieveAll() throws AuctifyException;
	   public int create(T object) throws AuctifyException;
	   public void update(T object) throws AuctifyException;
	   public void delete(T object) throws AuctifyException;
	}
