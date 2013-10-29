/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class AuctionManager implements CRUD_Interface<Auction>{

	private List<Auction> auctionList;
	private CRUD_Interface<Auction> auctionDatabaseCRUD;

	public AuctionManager(){
		auctionList = new SortedArrayList<Auction>();
		auctionDatabaseCRUD = new AuctionDatabaseCRUD();
	}

	@Override
	public Auction retrieve(Object actId) throws AuctifyException{
		int auctionId = (Integer)actId;
		Auction auction = getAuctionFromAuctionList(auctionId);//TODO change this to the id of the auction
		if (auction == null){
			auction = auctionDatabaseCRUD.retrieve(auctionId);
			if (auction != null) {
				auctionList.add(auction); 
			}
			else { throw new AuctifyException("auction not found"); }
		}
		return auction;
	}

	@Override
	public int create(Auction auction) throws AuctifyException {
		int newAuctionId = -1;
		try {
		newAuctionId = auctionDatabaseCRUD.create(auction);
		auction.setAuctionId(newAuctionId);
		auctionList.add(auction);
		} catch (AuctifyException ae) {
			throw new AuctifyException(ae.getMessage());
		}
		return newAuctionId;
	}
	
	/**
	 * Attempt to get a auction from auctionList
	 * @param auctionId
	 * @return the auction. returns null when auction is not found
	 */
	private Auction getAuctionFromAuctionList(int auctionId){
		Auction auction = null;
		int index = Collections.binarySearch(auctionList, new Auction(auctionId));
		System.out.println(auctionList);
		if ( index >= 0){
			auction = auctionList.get(index);
		}
		return auction;
	}
	
	/**
	 * Returns all auctions from auctionList
	 * @return ArrayList<Auction> with all auctions.
	 * @throws AuctifyException when there are no auctions
	 */
	public ArrayList<Auction> retrieveAll() throws AuctifyException {
		ArrayList<Auction> auctions = new ArrayList<Auction>();
		auctions = auctionDatabaseCRUD.retrieveAll();
		if (auctions != null) {
			return auctions;
		}
		else {
			throw new AuctifyException("No auctions found in auctionmanager");
		}
	}



	//Uninplemented methods
	public ArrayList<Auction> search(String search) {System.out.println("Not implemented");return null;}
	public void update(Auction object) {System.out.println("Not implemented");}
	public void delete(Auction object){System.out.println("Not implemented");}
}

