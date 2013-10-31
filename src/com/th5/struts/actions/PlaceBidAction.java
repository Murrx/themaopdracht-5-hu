package com.th5.struts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.struts.awareness.UserAware;

public class PlaceBidAction extends ActionSupport implements UserAware, SessionAware {

	private User user;
	private Map session;
	private int auctionId;
	private int bidAmount = 20; // NEEDS TO BE REMOVED LATER
	
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		
		user.bidOnAuction(auctionId, bidAmount);
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

	public int getBidAmount() {
		return bidAmount;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
}
