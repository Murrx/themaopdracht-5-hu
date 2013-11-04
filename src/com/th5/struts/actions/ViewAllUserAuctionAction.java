package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.User;
import com.th5.struts.awareness.UserAware;

@SuppressWarnings("serial")
public class ViewAllUserAuctionAction extends ActionSupport implements
		UserAware {

	private Collection<Auction> allAuctions;
	private User user;
	private Collection<Bid> allBids;

	@Override
	public String execute() throws Exception {
		try {

			allAuctions = user.getMyAuctions().values();
			
			Collection<Auction> tempBidAuctions = user.getRelevantAuctions().values();
			if (tempBidAuctions != null && tempBidAuctions.size() > 0) {
				for (Auction auction : (Auction[])tempBidAuctions.toArray()) {
					allBids.addAll((Collection<? extends Bid>) auction.getBids());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error: " + e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public Collection<Auction> getAllAuctions() {
		return this.allAuctions;
	}

	public Collection<Bid> getAllBids() {
		return this.allBids;
	}

	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;

	}
}