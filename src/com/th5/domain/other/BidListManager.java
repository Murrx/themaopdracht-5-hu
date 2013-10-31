package com.th5.domain.other;

import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;

public class BidListManager {
	private List<Bid> bids;
	private CRUD_Interface<Bid> dbCRUD;
	private Auction auction;
	private boolean inSync = false;
	
	public BidListManager(Auction auction) {
		this.auction = auction;
		bids = new SortedArrayList<Bid>();
		dbCRUD = new BidDatabaseCRUD();
	}
	
	public void add(Bid bid) throws AuctifyException{
		dbCRUD.create(bid);
		bids.add(bid);
	}
	
	public boolean isEmpty(){
		if (!inSync)syncList();
		return bids.isEmpty();
	}
	
	public int size(){
		if (!inSync)syncList();
		return bids.size();
	}
	
	public Bid get(int index){
		if (!inSync)syncList();
		return bids.get(index);
	}
	
	public List<Bid> getBids(){
		if (!inSync)syncList();
		return bids;
	}
	
	public void syncList(){
		try {
			bids = dbCRUD.search(Integer.toString(auction.getAuctionId()));
			inSync = true;
		} catch (AuctifyException e) {
			System.out.println("BidListManager.syncList::Failed to synchronise lists");
			e.printStackTrace();
		}
	}
	
}
