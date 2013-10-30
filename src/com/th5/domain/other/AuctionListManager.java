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

public class AuctionListManager {
	private static CRUD_Interface<Auction> auctionDatabaseCRUD = new AuctionDatabaseCRUD();
	private static List<Auction> allAuctions = retrieveAllAuctions();
	private boolean isAuctionListComplete = false;
	private User user;
	private List<Auction> auctionList;

	public AuctionListManager() {
		auctionList = new SortedArrayList<Auction>();
	}

	public ArrayList<Auction> getAuctionList() {
		if (!isAuctionListComplete) {
			return retrieveAllUserAuctions();
		}
		return (ArrayList<Auction>) auctionList;
	}

	public ArrayList<Auction> retrieveAllUserAuctions() {
		if (allAuctions.size() > 0) {
			for (Auction a : allAuctions) {
				if (a.getOwner().getUserId() == user.getUserId()) {
					auctionList.add(a);
				}
			}
			if (auctionList.size() > 0) {
				isAuctionListComplete = true;
			}
		}
		return (ArrayList<Auction>) auctionList;
	}

	public static Auction retrieve(Object id) throws AuctifyException {
		int auctionId = (Integer) id;
		Auction auction = getAuctionById(auctionId);
		if (auction == null) {
			throw new AuctifyException("auction with id " + id + "not found");
		}
		return auction;
	}

	public int create(Auction auction) throws AuctifyException {
		int newAuctionId = -1;
		try {
			newAuctionId = auctionDatabaseCRUD.create(auction);
			auction.setAuctionId(newAuctionId);
			auctionList.add(auction);
			allAuctions.add(auction);
		} catch (AuctifyException e) {
			//e.printStackTrace();
			throw new AuctifyException(e.getMessage());
		}
		return newAuctionId;
	}

	/**
	 * Attempt to get a auction from allAuctions
	 * 
	 * @param auctionId
	 * @return the auction. returns null when auction is not found
	 */
	public static Auction getAuctionById(int auctionId) {
		Auction auction = null;
		int index = Collections.binarySearch(allAuctions, new Auction(auctionId));
		if ( index >= 0){
			auction = allAuctions.get(index);
		}
		return auction;
	}

	/**
	 * Returns all auctions from auctionList
	 * 
	 * @return ArrayList<Auction> with all auctions.
	 */
	public static ArrayList<Auction> retrieveAllAuctions() {
		ArrayList<Auction> auctions = new SortedArrayList<Auction>();
		try {
			List<Auction> tempList = auctionDatabaseCRUD.retrieveAll();
			for (Auction auction : tempList) {
				auctions.add(auction);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return auctions;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
