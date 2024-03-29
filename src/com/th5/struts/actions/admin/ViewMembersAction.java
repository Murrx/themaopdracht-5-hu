package com.th5.struts.actions.admin;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;

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
public class ViewMembersAction extends ActionSupport {

	private Collection<User> users;
	
	public String execute() {
		AuctionServiceInterface service = ServiceProvider.getService();
		users = service.getUserMap().values();
		return ActionSupport.SUCCESS;
	}

	public Collection<User> getUsers() {
		return users;
	}
	
	
	
}
