package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.UserDao;

/**
 * Class that contains all the login-related methods.
 * 
 * @author Robin Altena
 * @author Martin Bakker
 * @author Dimiter Geelen
 * @author Joris Rijkes
 * @version 0.1 alpha
 */
public class LoginAction extends ActionSupport {

	private String username;
	private String password;

	/**
	 * This function executes the login action. If the username and the password both
	 * equal <code>admin</code>, then the user is logged in.
	 *
	 * @return <code>success</code> if the login is succesful, <br>
	 *  	   <code>error</code> if the login information is wrong.
	 */
	public String execute() {
		User user = ServiceProvider.getService().login(username, password);
		if (user == null) return ActionSupport.ERROR;
		else {
			username = user.getUsername();
			return ActionSupport.SUCCESS;
		}
	}
	/**
	 * This method validates the LoginAction for valid input. If the input is valid, then the LoginAcion execute will be called.
	 * @return void
	 */
	@Override
	public void validate() {

		/*String loginEmailRegex = "A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z\\S]{2,4}";
		
		if (username.trim().equals("")) {
			addFieldError("username", "username is required");
		}
		
		else if (!username.matches(loginEmailRegex)) {
			addFieldError("username", "Invalid username");
		}
		
		String loginPasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		
	    if (password.trim().equals("")) {
			addFieldError("password", "password is required");
		}
				
		else if (!password.matches(loginPasswordRegex)) {
			addFieldError("password", "Invalid password");
		}*/
	}

	/**
	 * Gets the username from the Username textfield.
	 * This function always returns the value of the Username textfield, even
	 * if the textfield is empty. 
	 *
	 * @return	<code>String</code> input of the Username textfield
	 * @see #setUsername(String)
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username in the Username textfield.
	 * <p>
	 * <i>This function is currently not in use.</i>
	 *
	 * @param username	<code>String</code> the new username to set
	 * @see #getUsername()
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password from the Password textfield.
	 * This function always returns the value of the Password textfield, even
	 * if the textfield is empty. 
	 *
	 * @return	<code>String</code> input of the Password textfield
	 * @see #getPassword(String)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password in the Password textfield.
	 * <p>
	 * <i>This function is currently not in use.</i>
	 *
	 * @param password	<code>String</code> the new password to set
	 * @see #getPassword()
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

