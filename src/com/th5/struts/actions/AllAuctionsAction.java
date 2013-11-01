package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.th5.domain.model.Auction;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

@Conversion()
@SuppressWarnings("serial")
public class AllAuctionsAction extends ActionSupport {

	private List<Auction> allAuctions;

	@Override
	public String execute() throws Exception {
		allAuctions = ServiceProvider.getService().getAllAuctions();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		//TODO : validate auctions
	}
	
	public List<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	

}
