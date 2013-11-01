package com.th5.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.AuctionListSynced;

public class ViewAuctionAction extends ActionSupport{
	int id;
	Auction auction;
	User owner;
	int nextBidAmount;
	Bid highestBid;
	
	int endTimeDay, endTimeMonth, endTimeYear;
	
	@Override
	public String execute() throws Exception {

		endTimeDay = auction.getEndTimeDate();
		endTimeMonth = auction.getEndTimeMonth();
		endTimeYear = auction.getEndTimeYear();
		highestBid = auction.getHighestBid();
		
		owner = ServiceProvider.getService().getUserById(auction.getOwner().getUserId());
		nextBidAmount = auction.calculateNextBidAmount();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		try {
			auction = AuctionListSynced.retrieve(id);
		} catch (AuctifyException e) {
			e.printStackTrace();
			addActionError("Invallid auction Id");
		}
	}

	public int getEndTimeMonth() {
		return endTimeMonth;
	}

	public int getEndTimeYear() {
		return endTimeYear;
	}

	public int getEndTimeDay() {
		return endTimeDay;
	}

	public Bid getHighestBid() {
		return highestBid;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Auction getAuction(){
		return auction;
	}
	
	public User getOwner() {
		return owner;
	}

	public int getNextBidAmount() {
		return nextBidAmount;
	}	
}