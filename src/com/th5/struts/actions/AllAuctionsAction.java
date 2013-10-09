package com.th5.struts.actions;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.th5.domain.model.Auction;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

@Conversion()
@SuppressWarnings("serial")
public class AllAuctionsAction extends ActionSupport {

	private ArrayList<Auction> allAuctions;

	@Override
	public String execute() throws Exception {
		try {
			allAuctions = ServiceProvider.getService().getAllAuctions();
		} catch (AuctifyException e) {
			System.out.println("All Auctions Action ERROR - " +e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		//TODO : validate auctions
	}
	
	public ArrayList<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	

}
