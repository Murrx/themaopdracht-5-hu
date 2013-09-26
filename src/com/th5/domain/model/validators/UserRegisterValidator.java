/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 24 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import sun.print.resources.serviceui;

import com.th5.domain.model.User;

public class UserRegisterValidator implements ValidatorInterface<User> {
	
	private List<AttributeError> errorList = new ArrayList<AttributeError>();
	
	@Override
	public List<AttributeError> validate(User user) {
		isValidDisplayName(user);
		isValidPassword(user);
		isValidEmailAddress(user.getEmail());
		return errorList;
	}
	
	public void isValidEmailAddress(String email) {
		   
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		     errorList.add(new AttributeError("email", "Invalid email adress"));
		   }
		   
		}
	
	public void isValidPassword(User user) {
		
		
		if (user.getPassword() == null) {
			errorList.add(new AttributeError("password","password is required"));
		} 
		
		else if (user.getPassword().trim().equals("")) {
			errorList.add(new AttributeError("password","password is required"));
		}
				
		else if (user.getPassword().trim().length() < 8) {
			errorList.add(new AttributeError("password","Password has to be atleast 8 characters long"));
		}
		
		else if (user.getPassword().length() >= 8) {
			boolean upper = false;
			boolean lower = false;
			boolean number = false;
			boolean leegwit = false;
			for (char c : user.getPassword().toCharArray()) {
				if (Character.isUpperCase(c)) {
					upper = true;
				} else if (Character.isLowerCase(c)) {
					lower = true;
				} else if (Character.isDigit(c)) {
					number = true;
				} else if (Character.isSpaceChar(c)) {
					leegwit = true;
				}
			}
			if (!upper) {
				errorList.add(new AttributeError("password", "Password must contain atleast 1 upper case character"));
			}  if (!lower) {
				errorList.add(new AttributeError("password","Password must contain atleast 1 lower case character"));
			} if (!number) {
				errorList.add(new AttributeError("password","Password must contain atleast 1 digit"));
			}  if (leegwit) {
				errorList.add(new AttributeError("password","Passord may not contain emptye/white spaces"));
			}
		}
	}
	
	public void isValidDisplayName(User user) {
		
		String regex = "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$";
		
		if (user.getDisplayName() == null) {
			errorList.add(new AttributeError("displayName","Display name is required"));
		}
		
		else if (user.getDisplayName().trim().equals("")) {
			errorList.add(new AttributeError("displayName","Display name is required"));
		}
				
		else if (user.getDisplayName().trim().length() < 2) {
			errorList.add(new AttributeError("displayName","Display name has to be atleast 2 characters long"));
		}

		else if (user.getDisplayName().matches(regex)) {
			errorList.add(new AttributeError("displayName","Display name may not contain special characters"));
		}
		
	}
	
}
