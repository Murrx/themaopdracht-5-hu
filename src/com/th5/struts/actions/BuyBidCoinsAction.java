package com.th5.struts.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.struts.awareness.UserAware;

@SuppressWarnings("serial")
public class BuyBidCoinsAction extends ActionSupport implements UserAware, SessionAware {

	private User user;
	private int amount;
	
	private SessionMap<String, Object> userSession;

	public String execute() throws AuctifyException {
		try {
			user.addBidCoins(amount);
		} catch (AuctifyException e) {
			throw e;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = (SessionMap<String, Object>) session;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount (int amount) {
		this.amount = amount;
	}
}
