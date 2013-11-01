package com.th5.domain.model;

import java.util.Calendar;

import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListSynched;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.BidDatabaseCRUD;

public class Bid implements Comparable<Bid> {

	private int bid_Id;
	private User user;
	private Auction auction;

	private Calendar timestamp;
	private int bidAmount;

	
	/**Use this constructor to create new Bids
	 * @param user that creates the bid
	 * @param auction the auction the bid is placed on
	 * @param bidAmount 
	 * @throws AuctifyException
	 */
	public Bid(User user, Auction auction, int bidAmount) throws AuctifyException {
		this.user = user;
		this.auction = auction;
		this.bidAmount = bidAmount;
		this.timestamp = Calendar.getInstance();
		this.bid_Id = BidDatabaseCRUD.generateId();

	}

	/**Use this constructor to restore bids from database
	 * @param bidId
	 * @param userId of the user that created the bid
	 * @param auctionId of the auction the bid belongs to
	 * @param timestamp
	 * @param bidAmount
	 * @throws AuctifyException 
	 */
	public Bid(int bidId, int userId, int auctionId, Calendar timestamp, int bidAmount) throws AuctifyException{
		this.bid_Id = bidId;
		this.user = ServiceProvider.getService().getUserById(userId);
		this.auction = AuctionListSynched.getAuctionById(auctionId);
		this.timestamp = timestamp;
		this.bidAmount = bidAmount;
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
