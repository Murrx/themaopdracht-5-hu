package com.th5.struts.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;
import com.th5.struts.awareness.UserAware;

public class ViewAllUserAuctionAction extends ActionSupport implements UserAware {
	
	private ArrayList<Auction> allAuctions;
	private User user;

	@Override
	public String execute() throws Exception {
		try {
			allAuctions = user.getActionListManager().getAuctionList();
		} catch (Exception e) {
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public ArrayList<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
}
