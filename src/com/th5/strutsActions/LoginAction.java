package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.User;
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
		UserDao uDao = new UserDao();

		User user = uDao.login(username, password);

		if (user != null){
			username = user.getUsername();
			return "success";
		}
		else return "error";

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

