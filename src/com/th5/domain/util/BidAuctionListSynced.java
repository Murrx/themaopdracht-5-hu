package com.th5.domain.util;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.queries.Queries;

public class BidAuctionListSynced{

	private List<Auction> bidAuctions;
	private BidDatabaseCRUD dbCRUD = new BidDatabaseCRUD();

	private User user;


	private boolean inSync = false;

	public BidAuctionListSynced(User user){
		this.user = user;
		this.bidAuctions = new SortedArrayList<Auction>();

	}

	public void add(Auction auction) {
		if (!bidAuctions.contains(auction)) {
		bidAuctions.add(auction);
		}
	}

	public boolean isEmpty() {
		if (!inSync)synchronise();
		return bidAuctions.isEmpty();
	}

	public int size() {
		if (!inSync)synchronise();
		return bidAuctions.size();
	}

	public Auction get(int index) {
		if (!inSync)synchronise();
		return bidAuctions.get(index);
	}
	
	public int indexOf(Auction auction) {
		if (!inSync)synchronise();
	
		int index = Collections.binarySearch(bidAuctions, new Auction(auction.getAuctionId()));
		if ( index > 0){
			index = -1;
		}
		return index;
	}

	public void synchronise() { //TODO: Currently loops through allAuctions list. Might want to write a db query for some more efficiency.

		try {
//			aDBC.retieveAllBidAuctions(user);
			dbCRUD.search(Integer.toString(user.getUserId()), Queries.userGetAllBids);
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

	public void remove(Auction t) {
		// TODO Auto-generated method stub
		
	}
}
