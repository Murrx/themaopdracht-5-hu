package com.th5.struts.actions.admin;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;

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
public class ViewStatsAction extends ActionSupport {


	private Collection<Bid> allBids;
	private int numBids;
	
	public String execute() {
		
		AuctionServiceInterface service = ServiceProvider.getService();
		
		numBids = 1;

		allBids = service.getAllBids().values();
		
		
		return ActionSupport.SUCCESS;
	}

	public Collection<Bid> getAllBids() {
		return allBids;
	}

	public int getNumBids() {
		return numBids;
	}
	
	
	
	

}
