package com.th5.domain.other;

import java.util.HashMap;
import java.util.Map;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.UserDatabaseCRUD;

public class UserMapSynched implements DatabaseSyncMap<User> {
	private Map<String,User> users;
	private CRUD_Interface<User> dbCRUD;
	private boolean inSync = false;
	
	public UserMapSynched(Auction auction) {
		users = new HashMap<String,User>();
		dbCRUD = new UserDatabaseCRUD();
	}
	
	@Override
	public void add(User user) throws AuctifyException {
	
	}
	
	public boolean isEmpty(){
		if (!inSync)synchronise();
		return users.isEmpty();
	}
	
	public int size(){
		if (!inSync)synchronise();
		return users.size();
	}
	
	public User get(int index){
		if (!inSync)synchronise();
		return users.get(index);
	}
	
	public Map<String,User> getUsers(){
		if (!inSync)synchronise();
		return users;
	}
	
	public void synchronise(){
//		try {
//			users = dbCRUD.search(Integer.toString(auction.getAuctionId()));
//			inSync = true;
//		} catch (AuctifyException e) {
//			System.out.println("BidListManager.syncList::Failed to synchronise lists");
//			e.printStackTrace();
//		}
	}
}
