package com.th5.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;
import com.th5.domain.service.ServiceProvider;

public class ViewAuctionAction extends ActionSupport{
	int id;
	Auction auction;
	User owner;
	int nextBidAmount;
	
	@Override
	public String execute() throws Exception {

		owner = ServiceProvider.getService().getUserById(auction.getOwner().getUserId());
		nextBidAmount = auction.calculateNextBidAmount();
		return ActionSupport.SUCCESS;
	}
	
	@Override
	public void validate() {
		try {
			auction = AuctionListManager.retrieve(id);
		} catch (AuctifyException e) {
			e.printStackTrace();
			addActionError("Invallid auction Id");
		}
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
