package com.th5.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.CalendarRange;
import com.th5.domain.util.Filterable;
import com.th5.persistance.BidDatabaseCRUD;

public class Bid implements Comparable<Bid>, Identifiable<String>, Filterable {

	private int bid_Id;
	private int userId;
	private int auctionId;
	private User user;
	private Auction auction;
	
	private Calendar timestamp;
	private int bidAmount;
	private BidStatus bidStatus;
	
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
		this.timestamp = new GregorianCalendar();
		this.bid_Id = BidDatabaseCRUD.generateId();
		generateBidStatus(auction);

	}

	/**Use this constructor to restore bids from database
	 * @param bidId
	 * @param userId of the user that created the bid
	 * @param auctionId of the auction the bid belongs to8
	 * @param timestamp
	 * @param bidAmount
	 * @throws AuctifyException 
	 */
	public Bid(int bidId, int userId, int auctionId, Calendar timestamp, int bidAmount) throws AuctifyException{
		this.bid_Id = bidId;
		this.auctionId = auctionId;
		this.timestamp = timestamp;
		this.bidAmount = bidAmount;
		this.userId = userId;
	}
	
	public Bid() {
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
		if (user == null)
			try {
				user = ServiceProvider.getService().getUserById(Integer.toString(userId));
			} catch (AuctifyException e) {
				e.printStackTrace();
			}
		return user;
	}

	public Auction getAuction() {
		if(auction == null) auction = ServiceProvider.getService().getAuctionById(auctionId);
		return auction;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}
	
	public int getDay(){
		return timestamp.get(Calendar.DATE);
	}
	
	public int getMonth(){
		return timestamp.get(Calendar.MONTH)+1;
	}
	
	public int getYear(){
		return timestamp.get(Calendar.YEAR);
	}

	public int getBidAmount() {
		return bidAmount;
	}
	
	public void setBid_Id(int bid_Id) {
		this.bid_Id = bid_Id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public int compareTo(Bid bid) {
		return this.timestamp.compareTo(bid.timestamp);

	}
	
	public String toString(){
		return Integer.toString(this.bid_Id);
	}

	@Override
	public String getIdentifier() {
		return Integer.toString(bid_Id);
	}
	
	@Override
	public boolean equals(Object other) {
		boolean equals = true;
		equals = other instanceof Bid;
		if(equals){
			Bid otherBid = (Bid) other;
			equals = this.bid_Id == otherBid.bid_Id;
		}
		return equals;
	}
	
	public BidStatus getBidStatus() {
		this.generateBidStatus(ServiceProvider.getService().getAuctionById(auctionId));
		return bidStatus;
	}

	public void setBidStatus(BidStatus bidStatus){
		this.bidStatus = bidStatus;
	}
	
	public int getAuctionId() {
		return auctionId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void generateBidStatus(Auction auction){
	
		boolean highestBid = this.equals(auction.getHighestBid()) || auction.getHighestBid() == null;
		boolean auctionStillActive = auction.getStatus().getRightsValue() >= Status.ACTIVE.getRightsValue();
		
		if (highestBid && auctionStillActive) {
			this.setBidStatus(BidStatus.WINNING);
		} else if (highestBid && !auctionStillActive) {
			this.setBidStatus(BidStatus.WON);
		} else if (!highestBid && auctionStillActive) {
			this.setBidStatus(BidStatus.LOSING);
		} else {
			this.setBidStatus(BidStatus.LOST);
		}
	}

	@Override
	public Boolean filter(Map<String, Object> filter) {
		Boolean valid = true;
		if(filter != null) {
			Iterator<Entry<String, Object>> it = filter.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, Object> obj = it.next();
				switch(obj.getKey()) {
					case "date":
						if(obj.getValue() instanceof CalendarRange) {
							if(!((CalendarRange)obj.getValue()).withinRange(timestamp)) {
								valid = false;
							}
							if(valid) {
								Calendar low = ((CalendarRange)obj.getValue()).getLow();
								Calendar high = ((CalendarRange)obj.getValue()).getHigh();
								
								System.out.println(timestamp.get(Calendar.DATE) + timestamp.get(Calendar.HOUR_OF_DAY) + timestamp.get(Calendar.MINUTE) + " valid for " + low.get(Calendar.DATE) + low.get(Calendar.HOUR_OF_DAY) + low.get(Calendar.MINUTE) +"-" + high.get(Calendar.DATE) + high.get(Calendar.HOUR_OF_DAY) + high.get(Calendar.MINUTE));
							}
						} else if(obj.getValue() instanceof Calendar) {
							if(!timestamp.equals(obj.getValue())) {
								valid = false;
							}
							if(valid) {
								System.out.println(bid_Id + " valid for " + ((Calendar)obj.getValue()).get(Calendar.DATE));
							}
						}
					break;
				}
			}
		}
		return valid;
	}


}