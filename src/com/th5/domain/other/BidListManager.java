package com.th5.domain.other;

import java.util.List;

import com.th5.domain.model.Bid;

public class BidListManager {
	List<Bid> bids;
	
	public BidListManager() {
		bids = new SortedArrayList<Bid>();
	}
	
	public void add(Bid bid){
		bids.add(bid);
	}
	
	public boolean isEmpty(){
		return bids.isEmpty();
	}
	
	public int size(){
		return bids.size();
	}
	
	public Bid get(int index){
		return bids.get(index);
	}
	
	public List<Bid> getBids(){
		return bids;
	}
	
}
