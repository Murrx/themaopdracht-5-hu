package com.th5.strutsActions;

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
public class LoginAction extends ActionSupport implements SessionAware {

	private String login_email;
	private String login_password;
	private SessionMap<String, Object> userSession;
	private User user;

	/**
	 * This function executes the login action. If the email and the password
	 * both equal <code>admin</code>, then the user is logged in.
	 * 
	 * @return <code>success</code> if the login is succesful, <br>
	 *         <code>error</code> if the login information is wrong.
	 */
	public String execute() {
		
		userSession.put("user", user);
		return ActionSupport.SUCCESS;

	}

	/**
	 * This method validates the LoginAction for valid input. If the input is
	 * valid, then the LoginAcion execute will be called.
	 * 
	 * @return void
	 */
	@Override
	public void validate() {
				
		if ("".equals(login_email.trim())) {
			addFieldError("login_email", "username is required");
		}
		if ("".equals(login_password.trim())) {
			addFieldError("login_password", "password is required");
		} else {
			
			User foundUser = ServiceProvider.getService().login(login_email,
					login_password);
			
			if (foundUser == null) {
				addFieldError("login_email", "Invalid username or password");
			} else {
				user = foundUser;
			}
		}
	}

	/**
	 * Gets the email from the email textfield. This function always returns the
	 * value of the email textfield, even if the textfield is empty.
	 * 
	 * @return <code>String</code> input of the email textfield
	 * @see #setEmail(String)
	 */
	public String getLogin_email() {
		return login_email;
	}

	/**
	 * Sets the email in the emial textfield.
	 * <p>
	 * <i>This function is currently not in use.</i>
	 * 
	 * @param username
	 *            <code>String</code> the new email to set
	 * @see #getEmail()
	 */
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}

	/**
	 * Gets the password from the Password textfield. This function always
	 * returns the value of the Password textfield, even if the textfield is
	 * empty.
	 * 
	 * @return <code>String</code> input of the Password textfield
	 * @see #getPassword(String)
	 */
	public String getLogin_password() {
		return login_password;
	}

	/**
	 * Sets the password in the Password textfield.
	 * <p>
	 * <i>This function is currently not in use.</i>
	 * 
	 * @param password
	 *            <code>String</code> the new password to set
	 * @see #getPassword()
	 */
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = (SessionMap<String, Object>) session;
	}
}
