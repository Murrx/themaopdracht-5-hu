package com.th5.struts.actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.Status;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.Filter;

/**
 * Class that contains all the login-related methods.
 * 
 * @author Robin Altena
 * @author Martin Bakker
 * @author Dimiter Geelen
 * @author Joris Rijkes
 * @version 0.1 alpha
 */
@SuppressWarnings("serial")
public class WelcomeAction extends ActionSupport {

	private Collection<Auction> popularAuctions;
	private Collection<Auction> latestAuctions;
	private Collection<Bid> latestBids;
	
	public String execute() throws Exception {
		HashMap<String, Object> flags = new HashMap<String, Object>();
		flags.put("status", Status.ACTIVE);
		
		AuctionServiceInterface service = ServiceProvider.getService();

		Filter<Auction> popularFilter = new Filter<Auction>(service.getPopularAuctions());
		popularFilter.setFlags(flags);
		Filter<Auction> latestFilter = new Filter<Auction>(service.getLatestAuctions());
		latestFilter.setFlags(flags);

		
		popularAuctions = popularFilter.getResult();
		latestAuctions = latestFilter.getResult();
		
		latestBids = service.getLatestBids();
		return ActionSupport.SUCCESS;
	}

	public Collection<Auction> getPopularAuctions() {
		return popularAuctions;
	}

	public Collection<Auction> getLatestAuctions() {
		return latestAuctions;
	}

	public Collection<Bid> getLatestBids() {
		return latestBids;
	}
}
