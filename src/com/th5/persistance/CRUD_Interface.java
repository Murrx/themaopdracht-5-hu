package com.th5.persistance;

import java.util.ArrayList;

import com.th5.domain.model.User;

public interface CRUD_Interface<T>{
	
	   
	   public T retrieve(String identifier);
	   public ArrayList<T> search(String search);
	   public ArrayList<T> retrieveAll();
	   public boolean create(T object);
	   public void update(T object);
	   public void delete(T object);
	}
