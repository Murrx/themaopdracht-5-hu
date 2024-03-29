package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.Status;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.Filter;

@SuppressWarnings("serial")
public class AuctionsByCategory extends ActionSupport {
	
	private String category;
	private Collection<Auction> allAuctions;
	
	public String execute() {
		HashMap<String, Object> flags = new HashMap<String, Object>();
		Collection<Auction> auctions = ServiceProvider.getService().getAllAuctions().values();
		Filter<Auction> filterResult = new Filter<Auction>(auctions);
		flags.put("status", Status.ACTIVE);
		flags.put("category", Category.fromString(category));

		filterResult.setFlags(flags);
	
		allAuctions = filterResult.getResult();

		return ActionSupport.SUCCESS;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Collection<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> allAuctions) {
		this.allAuctions = allAuctions;
	}
}
