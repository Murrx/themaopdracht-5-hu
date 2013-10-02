package com.th5.struts.actions;

import java.util.Map;

import org.apache.catalina.Session;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
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
public class LogoutAction extends ActionSupport implements SessionAware {

	private SessionMap<String, Object> userSession;

	/**
	 * This function executes the login action. If the email and the password
	 * both equal <code>admin</code>, then the user is logged in.
	 * 
	 * @return <code>success</code> if the login is succesful, <br>
	 *         <code>error</code> if the login information is wrong.
	 */
	public String execute() {
		userSession.invalidate();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = (SessionMap<String, Object>) session;
	}
}
