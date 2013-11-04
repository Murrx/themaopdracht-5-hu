package com.th5.struts.actions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.th5.domain.model.Auction;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.Search;

@Conversion()
@SuppressWarnings("serial")
public class SearchAuctionsAction extends ActionSupport {

	private Collection<Auction> allAuctions;
	private String search;

	@Override
	public String execute() {
		try {
			Collection<Auction> auctions = ServiceProvider.getService().getAllAuctions().values();
			Search<Auction> searchResult = new Search<Auction>(auctions, search);
			allAuctions = searchResult.getResult();
		} catch(Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			System.out.println(errors);
		}
 		
		return ActionSupport.SUCCESS;
	}
	
	public Collection<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getSearch() {
		return search;
	}
}
