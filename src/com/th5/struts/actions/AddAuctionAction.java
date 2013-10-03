package com.th5.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

public class AddAuctionAction extends ActionSupport {
	
	private String 	auction_name, auction_description, auction_category,
					auction_price, auction_end_date;
	
	@Override
	public String execute() throws Exception {
		//ServiceProvider.getService().addAuction.....
		return ActionSupport.SUCCESS;
	}

	public String getAuction_name() {
		return auction_name;
	}

	public void setAuction_name(String auction_name) {
		this.auction_name = auction_name;
	}

	public String getAuction_description() {
		return auction_description;
	}

	public void setAuction_description(String auction_description) {
		this.auction_description = auction_description;
	}

	public String getAuction_category() {
		return auction_category;
	}

	public void setAuction_category(String auction_category) {
		this.auction_category = auction_category;
	}

	public String getAuction_price() {
		return auction_price;
	}

	public void setAuction_price(String auction_price) {
		this.auction_price = auction_price;
	}

	public String getAuction_end_date() {
		return auction_end_date;
	}

	public void setAuction_end_date(String auction_end_date) {
		this.auction_end_date = auction_end_date;
	}


}
