package com.th5.domain.model;

import java.util.Calendar;
import java.util.List;

import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.BidListManager;
import com.th5.domain.other.SortedArrayList;
import com.th5.domain.service.AuctionService;
import com.th5.domain.service.ServiceProvider;

public class Auction implements Comparable<Auction> {

	private int auctionId;
	private Calendar startTime;
	private Calendar endTime;
	private int startBid;
	

	private BidListManager bids;

	private Product product;
	private Category category;
	private Status status;

	private int userId;
	private User owner;

	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}

	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion) {
		this.startTime = Calendar.getInstance();
		this.endTime = endTime;
		this.startBid = startBid;

		this.category = category;
		this.status = Status.ACTIVE;
		this.product = new Product(productName, productDescripion);

		this.bids = new BidListManager();
	}

	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion, int auctionId, int userId) {
		this(endTime, startBid, category, productName, productDescripion);
		this.auctionId = auctionId;
		this.userId = userId;
	}

	public synchronized void addBid(Bid bid) throws AuctifyException {

		Bid highestBid = getHighestBid();

		if (bid.getUser().getUserId() == this.owner.getUserId()) {
			throw new AuctifyException("You are not allowed to place bids on your own auctions.");
		}

		if (highestBid != null && highestBid.getUser().getUserId() == bid.getUser().getUserId()) {
			throw new AuctifyException("You are already the highest bidder.");
		}

		if (bid.getBidAmount() == this.calculateNextBidAmount()) {
			if (highestBid != null) {
				highestBid.refundBidCoins();
			}

			bid.takeBidCoins();

			bids.add(bid);
		} else {
			throw new AuctifyException("Bid has to be higher than current bid. Please refresh your page and try again! NOOOOOO");
		}

	}

	public Bid getHighestBid() {
		Bid highestBid = null;

		if (!bids.isEmpty()) {
			highestBid = bids.get(bids.size() - 1);
		}
		return highestBid;
	}

	public int getHighestBidAmount() {
		int highestBidAmount = 0;
		if (!bids.isEmpty()) {
			highestBidAmount = bids.get(bids.size() - 1).getBidAmount();
		}
		return highestBidAmount;
	}

	public int calculateNextBidAmount() {
		int highestBidAmount = getHighestBidAmount();
		int nextBidAmount;

		if (highestBidAmount == 0) {
			nextBidAmount = startBid;
		} else {
			nextBidAmount = highestBidAmount % 100 * 5; // TODO Create an algorithm to
													// increase bid amount.
		}
		return nextBidAmount;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public int getStartTimeYear() {
		return startTime.get(Calendar.YEAR);
	}

	public int getStartTimeMonth() {
		return startTime.get(Calendar.MONTH);
	}

	public int getStartTimeDate() {
		return startTime.get(Calendar.DATE);
	}

	public int getStartTimeHours() {
		return startTime.get(Calendar.HOUR_OF_DAY);
	}

	public int getStartTimeMinutes() {
		return startTime.get(Calendar.MINUTE);
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public int getPercentage() {
		Long start = startTime.getTimeInMillis();
		Long end = endTime.getTimeInMillis();
		Long now = Calendar.getInstance().getTimeInMillis();
		double procent = (now.doubleValue() - start.doubleValue()) / (end.doubleValue() - start.doubleValue());
		if (procent < 0) {
			procent = 0;
		}
		if (procent > 1) {
			procent = 1;
		}
		return (int) (100 * procent);
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public int getEndTimeYear() {
		return endTime.get(Calendar.YEAR);
	}

	public int getEndTimeMonth() {
		return endTime.get(Calendar.MONTH);
	}

	public int getEndTimeDate() {
		return endTime.get(Calendar.DATE);
	}

	public int getEndTimeHours() {
		return endTime.get(Calendar.HOUR_OF_DAY);
	}

	public int getEndTimeMinutes() {
		return endTime.get(Calendar.MINUTE);
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public int getStartBid() {
		return startBid;
	}

	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int compareTo(Auction o) {
		if (auctionId > o.auctionId) {
			return 1;
		} else if (auctionId < o.auctionId) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return Integer.toString(auctionId);
	}

	public void setOwner(User owner) {
		this.owner = owner;
		if (this.userId == 0) {
			this.userId = owner.getUserId();
		}
	}

	public User getOwner() {
		if (owner == null) {
			try {
				setOwnerFromUserList();
			} catch (AuctifyException e) {
				e.printStackTrace();
			}
		}
		return owner;
	}

	private void setOwnerFromUserList() throws AuctifyException {
		AuctionService service = (AuctionService) ServiceProvider.getService();
		this.owner = service.getUserById(userId);
	}
	
	public BidListManager getBids(){
		return bids;
	}
}
