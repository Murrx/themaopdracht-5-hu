package com.th5.domain.util;

import java.util.Collections;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class BidListSynced implements DatabaseSyncedList<Bid>{
	private List<Bid> bids;
	private CRUD_Interface<Bid> dbCRUD;
	private Auction auction;
	private boolean inSync = false;
	
	public BidListSynced(Auction auction) {
		this.auction = auction;
		bids = new SortedArrayList<Bid>();
		dbCRUD = new BidDatabaseCRUD();
	}
	
	public void add(Bid bid) throws AuctifyException{
		dbCRUD.create(bid);
		bids.add(bid);
	}
	
	public boolean isEmpty(){
		if (!inSync)synchronise();
		return bids.isEmpty();
	}
	
	public int size(){
		if (!inSync)synchronise();
		return bids.size();
	}
	
	public Bid get(int index){
		if (!inSync)synchronise();
		return bids.get(index);
	}
	
	public List<Bid> getBids(){
		if (!inSync)synchronise();
		return bids;
	}
	
	public void synchronise(){
		try {
			bids = dbCRUD.search(Integer.toString(auction.getAuctionId()));
			inSync = true;
		} catch (AuctifyException e) {
			System.out.println("BidListManager.syncList::Failed to synchronise lists");
			e.printStackTrace();
		}
	}

	@Override
	public int indexOf(Bid bid) {
		if (!inSync)synchronise();
		int index = Collections.binarySearch(bids, bid);
		if ( index > 0){
			index = -1;
		}
		return index;
	}

	@Override
	@Deprecated
	public void remove(Bid bid) {
		// TODO Auto-generated method stub
	}
}
