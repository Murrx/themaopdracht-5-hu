/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 24 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.model.User;

public class UserRegisterValidator implements ValidatorInterface<User> {

	private List<AttributeError> errorList = new ArrayList<AttributeError>();
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/*^						#start of the line
	  [_A-Za-z0-9-\\+]+		#must start with string in the bracket [ ], must contains one or more (+)
	  (						#start of group #1
	    \\.[_A-Za-z0-9-]+	#follow by a dot "." and string in the bracket [ ], must contains one or more (+)
	  )*					#end of group #1, this group is optional (*)
	    @					#must contains a "@" symbol
	     [A-Za-z0-9-]+      #follow by string in the bracket [ ], must contains one or more (+)
	      (					#start of group #2 - first level TLD checking
	       \\.[A-Za-z0-9]+  #follow by a dot "." and string in the bracket [ ], must contains one or more (+)
	      )*				#end of group #2, this group is optional (*)
	      (					#start of group #3 - second level TLD checking
	       \\.[A-Za-z]{2,}  #follow by a dot "." and string in the bracket [ ], with minimum length of 2
	      )					#end of group #3
	$						#end of the line*/
	private static String DISPLAYNAME_PATTERN = "(?=.*?[`~!@#$%^&*()\\-_=+\\\\\\|\\[{\\]};:'\",<.>/?]).*$";
	
	@Override
	public List<AttributeError> validate(User user) {
		isValidDisplayName(user.getDisplayName());
		isValidPassword(user.getPassword());
		isValidEmailAddress(user.getEmail());
		return errorList;
	}

	public void isValidEmailAddress(String email) {

		if (email == null) {
			errorList.add(new AttributeError("email", "Email adress is null"));
		} else if (email.trim().length() == 0) {
			errorList.add(new AttributeError("email",
					"Email adress is required"));
		} else {

			if (!email.matches(EMAIL_PATTERN)) {
				errorList.add(new AttributeError("email",
						"Invalid email adress"));
			}
		}
	}

	public void isValidPassword(String password) {

		if (password == null) {
			errorList
					.add(new AttributeError("password", "password is required"));
		}

		else if (password.trim().equals("")) {
			errorList
					.add(new AttributeError("password", "password is required"));
		}

		else if (password.trim().length() < 8) {
			errorList.add(new AttributeError("password",
					"Password has to be atleast 8 characters long"));
		}

		else if (password.length() >= 8) {
			boolean upper = false;
			boolean lower = false;
			boolean number = false;
			boolean leegwit = false;
			for (char c : password.toCharArray()) {
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
				errorList
						.add(new AttributeError("password",
								"Password must contain atleast 1 upper case character"));
			}
			if (!lower) {
				errorList
						.add(new AttributeError("password",
								"Password must contain atleast 1 lower case character"));
			}
			if (!number) {
				errorList.add(new AttributeError("password",
						"Password must contain atleast 1 digit"));
			}
			if (leegwit) {
				errorList.add(new AttributeError("password",
						"Passord may not contain emptye/white spaces"));
			}
		}
	}

	public void isValidDisplayName(String displayName) {

		if (displayName == null) {
			errorList.add(new AttributeError("displayName",
					"Display name is required"));
		}

		else if (displayName.trim().equals("")) {
			errorList.add(new AttributeError("displayName",
					"Display name is required"));
		}

		else if (displayName.trim().length() < 2) {
			errorList.add(new AttributeError("displayName",
					"Display name has to be atleast 2 characters long"));
		}

		else if (displayName.matches(DISPLAYNAME_PATTERN)) {
			errorList.add(new AttributeError("displayName",
					"Display name may not contain special characters"));
		}

	}
	
	public void clearArray() {
		errorList.clear();
	}
}
