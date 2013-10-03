/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.persistance;

import java.util.ArrayList;

import com.th5.domain.model.Auction;
import com.th5.domain.other.AuctifyException;

public class AuctionDatabaseCRUD implements CRUD_Interface<Auction>{

	@Override
	public Auction retrieve(String identifier) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Auction> search(String search) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Auction> retrieveAll() throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		return (0);
	}

	@Override
	public void update(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		
	}

}
