package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.struts.awareness.UserAware;

public class ViewAllUserAuctionAction extends ActionSupport implements UserAware {
	
	private List<Auction> allAuctions;
	private User user;

	@Override
	public String execute() throws Exception {
		try {
			allAuctions = user.getActionManager().getAuctions();
			System.out.println(allAuctions);
		} catch (Exception e) {
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public List<Auction> getAllAuctions() {
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
