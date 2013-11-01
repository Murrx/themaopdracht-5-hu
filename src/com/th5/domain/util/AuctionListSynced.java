package com.th5.domain.util;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class AuctionListSynced implements DatabaseSyncedList<Auction> {

	private static CRUD_Interface<Auction> dbCRUD = new AuctionDatabaseCRUD();
	private List<Auction> auctions;
	private List<Auction> allAuctions = ServiceProvider.getService().getAllAuctions();

	private User user;


	private boolean inSync = false;

	public AuctionListSynced(User user){
		this.user = user;
		this.auctions = new SortedArrayList<Auction>();
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
	
	public void remove (Auction auction){
		try{
			dbCRUD.delete(auction.getAuctionId());
			auctions.remove(auction);
			allAuctions.remove(auction);
		}catch(AuctifyException e){
			e.printStackTrace();
		}
		
	}
}
