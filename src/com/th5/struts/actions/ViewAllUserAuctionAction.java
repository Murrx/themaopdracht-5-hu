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
	
	private ArrayList<Auction> allUserAuctions;
	private User user;

	@Override
	public String execute() throws Exception {
		try {
			System.out.println("actionklasse vieuwalleuserauction binnen! ");
			allUserAuctions = user.getActionListManager().getAuctionList();
		} catch (Exception e) {
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
	
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
}
