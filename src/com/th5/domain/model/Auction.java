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
	private int price;
	
	private Product product;
	private Category category;
	private Status status;
	
	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public Auction(Calendar endTime, int price, Category category, String productName, String productDescripion ) {
		this.startTime = Calendar.getInstance();
		this.endTime = endTime;
		this.price = price;
		
		this.category = category;
		this.status = Status.ACTIVE;
		this.product = new Product(productName, productDescripion);
	}
	
	public Auction(Calendar endTime, int price, Category category, String productName, String productDescripion , int auctionId) {
		this( endTime, price, category, productName, productDescripion);
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

	public Calendar getEndTime() {
		return endTime;
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
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
}