package com.th5.domain.util;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.AuctionDatabaseCRUD;

public class BidAuctionListSynced implements DatabaseSyncedList<Auction> {

	private List<Auction> bidAuctions;
	private AuctionDatabaseCRUD aDBC = new AuctionDatabaseCRUD();

	private User user;


	private boolean inSync = false;

	public BidAuctionListSynced(User user){
		this.user = user;
		this.bidAuctions = new SortedArrayList<Auction>();

	}

	@Override
	public void add(Auction auction) {
		if (!bidAuctions.contains(auction)) {
		bidAuctions.add(auction);
		}
	}

	@Override
	public boolean isEmpty() {
		if (!inSync)synchronise();
		return bidAuctions.isEmpty();
	}

	@Override
	public int size() {
		if (!inSync)synchronise();
		return bidAuctions.size();
	}

	@Override
	public Auction get(int index) {
		if (!inSync)synchronise();
		return bidAuctions.get(index);
	}
	
	@Override
	public int indexOf(Auction auction) {
		if (!inSync)synchronise();
	
		int index = Collections.binarySearch(bidAuctions, new Auction(auction.getAuctionId()));
		if ( index > 0){
			index = -1;
		}
		return index;
	}

	@Override
	public void synchronise() { //TODO: Currently loops through allAuctions list. Might want to write a db query for some more efficiency.

		try {
			aDBC.retieveAllBidAuctions(user);
		} catch (AuctifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inSync = true;
	}
	public List<Auction> getBidAuctions() {
		if (!inSync)synchronise();
		return bidAuctions;
	}
}
