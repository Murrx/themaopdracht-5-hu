package com.th5.struts.actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.Status;
import com.th5.domain.model.User;
import com.th5.domain.util.Filter;
import com.th5.struts.awareness.UserAware;

@SuppressWarnings("serial")
public class ViewAllUserAuctionAction extends ActionSupport implements
		UserAware {

	private Collection<Auction> allAuctions;
	private User user;
	private Collection<Bid> allBids;
	private Map<String, Bid> relevantAuctions = new HashMap<String, Bid>();

	@Override
	public String execute() throws Exception {
		try {
			allBids = user.getMyBids().values();
			if (allBids != null) {
				for(Bid bid : allBids){
					relevantAuctions.put(bid.getAuction().getIdentifier(), bid);
				}
			}
			
			HashMap<String, Object> flags = new HashMap<String, Object>();
			Filter<Auction> filterResult = new Filter<Auction>(user.getMyAuctions().values());
			flags.put("status", Status.ACTIVE);
			filterResult.setFlags(flags);
		
			allAuctions = filterResult.getResult();
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
	
	public Map<String, Bid> getRelevantAuctions() {
		return relevantAuctions;
	}
}
