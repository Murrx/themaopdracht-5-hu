package com.th5.struts.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

public class ViewAllUserAuctionAction extends ActionSupport{
	
	private ArrayList<Auction> allUserAuctions;
	private int userId;

	@Override
	public String execute() throws Exception {
		try {
			allUserAuctions = ServiceProvider.getService().getAllUserAuctions(userId);
		} catch (AuctifyException e) {
			System.out.println("All Auctions Action ERROR - " +e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		//TODO : validate auctions
	}
	
	public ArrayList<Auction> getAllUserAuctions() {
		return this.allUserAuctions;
	}
	
	public void setAllUserAuctions(ArrayList<Auction> al) {
		this.allUserAuctions = al;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
}
