package com.th5.domain.model;

import java.util.Calendar;

import com.th5.domain.other.AuctifyException;
import com.th5.persistance.BidDatabaseCRUD;

public class Bid implements Comparable<Bid> {

	private int bid_Id;
	private User user;
	private Auction auction;

	private Calendar timestamp;
	private int bidAmount;

	public Bid(User user, Auction auction, int bidAmount)
			throws AuctifyException {
		this.user = user;
		this.auction = auction;
		this.bidAmount = bidAmount;
		this.timestamp = Calendar.getInstance();
		this.bid_Id = new BidDatabaseCRUD().generateId();

	}

	public void refundBidCoins() throws AuctifyException {
		user.addBidCoins(bidAmount);
	}
	
	public void takeBidCoins() throws AuctifyException {
		user.takeBidCoins(bidAmount);
	}

	public int getBid_Id() {
		return bid_Id;
	}

	public User getUser() {
		return user;
	}

	public Auction getAuction() {
		return auction;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	@Override
	public int compareTo(Bid bid) {
		return this.timestamp.compareTo(bid.timestamp);

	}

}
