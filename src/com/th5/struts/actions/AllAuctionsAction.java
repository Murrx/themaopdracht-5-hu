package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.service.ServiceProvider;

@Conversion()
@SuppressWarnings("serial")
public class AllAuctionsAction extends ActionSupport {

	private Collection<Auction> allAuctions;
	private Category[] 			categories = Category.values();

	@Override
	public String execute() throws Exception {
		allAuctions = ServiceProvider.getService().getAllAuctions().values();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		//TODO : validate auctions
	}
	
	public Collection<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}
}
