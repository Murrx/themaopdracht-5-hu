package com.th5.struts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Status;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.AuctionDatabaseCRUD;

public class UnblockAuctionAction extends ActionSupport implements SessionAware{

	private int auctionId;
	private Map<String, Object> session;

	
	@Override
	public String execute() throws Exception {
		Auction auction = ServiceProvider.getService().getAuctionById(auctionId);
		
		auction.register(new AuctionDatabaseCRUD());
		
		auction.setStatus(Status.ACTIVE);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public void setAuctionId(int auctionId){
		this.auctionId = auctionId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
