package com.th5.struts.actions.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;

@SuppressWarnings("serial")
public class ViewMemberAction extends ActionSupport {

	private User user;
	private int userId;


	public String execute() {

		AuctionServiceInterface service = ServiceProvider.getService();
		

		try {
			user = service.getUserById(Integer.toString(userId));
		} catch (AuctifyException e) {
			e.printStackTrace();
		}

		return ActionSupport.SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
