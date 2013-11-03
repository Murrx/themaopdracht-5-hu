package com.th5.struts.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.BidDatabaseCRUD;

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

	private List<Auction> auctions;
	private List<Auction> popularAuctions;
	private List<Auction> latestAuctions;
	private List<Bid> latestBids;
	
	public String execute() {
		
		AuctionServiceInterface service = ServiceProvider.getService();

		auctions = service.getAllAuctions();
		
		popularAuctions = service.getPopularAuctions();
		latestAuctions = service.getLatestAuctions();
		
		try{ 
			latestBids = BidDatabaseCRUD.getLatestBids();
		} catch (AuctifyException AE) {
			AE.printStackTrace();
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public List<Auction> getPopularAuctions() {
		return popularAuctions;
	}

	public List<Auction> getLatestAuctions() {
		return latestAuctions;
	}

	public List<Bid> getLatestBids() {
		return latestBids;
	}
}
