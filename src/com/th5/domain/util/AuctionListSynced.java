package com.th5.domain.util;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionService;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class AuctionListSynced implements DatabaseSyncedList<Auction> {

	private static CRUD_Interface<Auction> dbCRUD = new AuctionDatabaseCRUD();
	private List<Auction> auctions;
	private AuctionServiceInterface service = ServiceProvider.getService();

	private User user;


	private boolean inSync = false;

	public AuctionListSynced(User user){
		this.user = user;
		this.auctions = new SortedArrayList<Auction>();
	}

	@Override
	public void add(Auction auction) throws AuctifyException {
		dbCRUD.create(auction);
		service.getAllAuctions().add(auction);
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
	
		int index = Collections.binarySearch(service.getAllAuctions(), new Auction(auction.getAuctionId()));
		if ( index > 0){
			index = -1;
		}
		return index;
	}

	@Override
	public void synchronise() { //TODO: Currently loops through allAuctions list. Might want to write a db query for some more efficiency.
		for (Auction auction : service.getAllAuctions()){
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
	//TODO:Needs to be moved
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
		int index = Collections.binarySearch(AuctionService.allAuctions, new Auction(auctionId));
		if ( index >= 0){
			auction = AuctionService.allAuctions.get(index);
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
}
