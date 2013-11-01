package com.th5.struts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.util.AuctionListSynced;
import com.th5.struts.awareness.UserAware;

public class PlaceBidAction extends ActionSupport implements UserAware, SessionAware {

	private User user;
	private Map session;
	private int auctionId;
	
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		Auction auction = AuctionListSynced.getAuctionById(auctionId);
		int bidAmount = auction.calculateNextBidAmount();
		
		try{
		user.bidOnAuction(auctionId, bidAmount);
		} catch (AuctifyException AE){
			addActionError(AE.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
}
