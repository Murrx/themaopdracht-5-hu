package com.th5.domain.other;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class AuctionListSynched implements DatabaseSyncList<Auction> {

	private static CRUD_Interface<Auction> dbCRUD = new AuctionDatabaseCRUD();
	private static List<Auction> allAuctions = retrieveAllAuctions();
	private List<Auction> auctions;

	private User user;


	private boolean inSync = false;

	public AuctionListSynched(User user){
		this.user = user;
	}

	@Override
	public void add(Auction auction) throws AuctifyException {
		dbCRUD.create(auction);
		allAuctions.add(auction);
		auctions.add(auction);
	}

	@Override
	public boolean isEmpty() {
		if (!inSync)synchronise();
		return auctions.isEmpty();
	}

	@Override
	public int size() {
		if (!inSync)synchronise();
		return auctions.size();
	}

	@Override
	public Auction get(int index) {
		if (!inSync)synchronise();
		return auctions.get(index);
	}
	
	@Override
	public int indexOf(Auction auction) {
		if (!inSync)synchronise();
	
		int index = Collections.binarySearch(allAuctions, new Auction(auction.getAuctionId()));
		if ( index > 0){
			index = -1;
		}
		return index;
	}

	@Override
	public void synchronise() { //TODO: Currently loops through allAuctions list. Might want to write a db query for some more efficiency.
		for (Auction auction : allAuctions){
			if(auction.getOwner().getUserId() == user.getUserId()){
				auctions.add(auction);
			}
		}
		inSync = true;
	}

	public List<Auction> getAuctions() {
		if (!inSync)synchronise();
		return auctions;
	}

	/**
	 * Retrieve all auctions from database
	 * 
	 * @return List<Auction> with all auctions
	 */
	public static List<Auction> retrieveAllAuctions() {
		List<Auction> auctions = new SortedArrayList<Auction>();
		try {
			List<Auction> tempList = dbCRUD.retrieveAll();
			for (Auction auction : tempList) {
				auctions.add(auction);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return auctions;
	}
	
	/**
	 * Attempt to get a auction from allAuctions
	 * 
	 * @param auctionId
	 * @return the auction. returns null when auction is not found
	 */
	//TODO:needs to be removed
	public static Auction getAuctionById(int auctionId) {
		Auction auction = null;
		int index = Collections.binarySearch(allAuctions, new Auction(auctionId));
		if ( index >= 0){
			auction = allAuctions.get(index);
		}
		return auction;
	}

	
	/**
	 * Attempt to retrieve a auction from allAuctions list
	 * 
	 * @param auctionId
	 * @return the auction. returns a auctifyException when auction is not found
	 */
	//TODO:needs to be removed
	public static Auction retrieve(Object id) throws AuctifyException {
		int auctionId = (Integer) id;
		Auction auction = getAuctionById(auctionId);
		if (auction == null) {
			throw new AuctifyException("auction with id " + id + "not found");
		}
		return auction;
	}

	//TODO:needs to be removed
	public int create(Auction auction) throws AuctifyException {
		int newAuctionId = -1;
		try {
			newAuctionId = dbCRUD.create(auction);
			auction.setAuctionId(newAuctionId);
			auctions.add(auction);
			allAuctions.add(auction);
		} catch (AuctifyException e) {
			//e.printStackTrace();
			throw new AuctifyException(e.getMessage());
		}
		return newAuctionId;
	}

}
