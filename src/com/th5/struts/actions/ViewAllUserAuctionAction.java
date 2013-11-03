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
	private List<Bid> allBids = new ArrayList<Bid>();

	@Override
	public String execute() throws Exception {
		try {

			allAuctions = user.geMyAuctions().values();
//			if (user.getRelevantAuctions() != null) {
//				for (Auction auc : user.getRelevantAuctions()) {
//					for (Bid bid : auc.getBids()) {
//						allBids.add(bid);
//					}
//				}
//			}

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

	public List<Bid> getAllBids() {
		return this.allBids;
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
