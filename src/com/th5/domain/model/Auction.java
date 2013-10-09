/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;

import java.util.Calendar;

public class Auction implements Comparable<Auction> {

	private int auctionId;
	private Calendar startTime;
	private Calendar endTime;
	private int startBid;
	
	private Product product;
	private Category category;
	private Status status;
	private User user;
	
	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion ) {
		this.startTime = Calendar.getInstance();
		this.endTime = endTime;
		this.startBid = startBid;
		
		this.category = category;
		this.status = Status.ACTIVE;
		this.product = new Product(productName, productDescripion);
	}
	
	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion , int auctionId) {
		this( endTime, startBid, category, productName, productDescripion);
		this.auctionId = auctionId;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	public int getPercentage() {
		Long start = startTime.getTimeInMillis();
		Long end = endTime.getTimeInMillis();
		Long now = Calendar.getInstance().getTimeInMillis();
		double procent = (now.doubleValue()-start.doubleValue())/(end.doubleValue()-start.doubleValue());
		if (procent < 0) {
			procent = 0;
		}
		if (procent > 1) {
			procent = 1;
		}
		return (int) (100*procent);
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
	
	public int getEndTimeMilis() {
		return endTime.compareTo(Calendar.getInstance());
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
		}
		else if (auctionId < o.auctionId) {
			return -1;
		}
		else {
			return 0;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}