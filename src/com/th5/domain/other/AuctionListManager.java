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
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class AuctionListManager{

	private List<Auction> auctionList;
	private static List<Auction> allAuctions;
	
	private CRUD_Interface<Auction> auctionDatabaseCRUD;

	public AuctionListManager(){
		auctionList = new SortedArrayList<Auction>();
		auctionDatabaseCRUD = new AuctionDatabaseCRUD();
	}

	public Auction retrieve(Object actId) throws AuctifyException{
		int auctionId = (Integer)actId;
		Auction auction = getAuctionFromAuctionList(auctionId);
		if (auction == null){
			auction = auctionDatabaseCRUD.retrieve(auctionId);
			if (auction != null) {
				auctionList.add(auction);
				//allAuctions.add(auction);
			}
			else { throw new AuctifyException("auction not found"); }
		}
		return auction;
	}

	public int create(Auction auction) throws AuctifyException {
		int newAuctionId = -1;
		try {
		newAuctionId = auctionDatabaseCRUD.create(auction);
		auction.setAuctionId(newAuctionId);
		auctionList.add(auction);
		//allAuctions.add(auction);
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
}

