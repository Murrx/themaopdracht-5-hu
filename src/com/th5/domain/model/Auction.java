/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;

import com.opensymphony.xwork2.ActionSupport;

public class Auction implements Comparable<Auction> {

	private long startTime;
	private long endTime;
	private int auctionId;
	private int statusId;
	private Product product;
	
	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public Auction(long startTime, long endTime, int statusId) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.statusId = statusId;
	}
	
	public Auction(int auctionId, long startTime, long endTime, int statusId) {
		this(startTime, endTime, statusId);
		this.statusId = statusId;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Product getProduct() {
		return product;
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

}
