package com.th5.struts.actions.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.UserDatabaseCRUD;

@SuppressWarnings("serial")
public class BlockMemberAction extends ActionSupport {

	private User user;
	private int userId;
	private UserDatabaseCRUD obs = new UserDatabaseCRUD();
	private String previousPage;

	public String execute() {
		AuctionServiceInterface service = ServiceProvider.getService();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		previousPage = request.getHeader("referer");

		try {
			user = service.getUserById(Integer.toString(userId));
			user.register(obs);
			user.setRights(UserRights.BLOCKED);
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

	public String getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}
	

}
