package com.th5.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Category;

public class AddAuctionFormAction extends ActionSupport{

	private Category[] categories = Category.values();
			
	@Override
	public String execute() throws Exception {
		
		return ActionSupport.SUCCESS;
	}

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}	
}
