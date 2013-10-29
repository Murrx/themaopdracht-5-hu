package com.th5.struts.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.th5.domain.model.Address;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.validators.AttributeError;
import com.th5.domain.model.validators.UserAddressValidator;
import com.th5.domain.model.validators.UserPersonValidator;
import com.th5.domain.model.validators.UserRegisterValidator;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

@Conversion()
@SuppressWarnings("serial")
public class EditProfileAction extends ActionSupport {

	private String  edit_email,
					edit_password, 
					edit_new_password, 
					edit_password2,
					edit_displayName,
		
					edit_firstName, 
					edit_lastName,
				
					edit_postalCode, 
					edit_houseNumber, 
					edit_street,
					edit_city;
	
	private int 	edit_gender;
	private Date	edit_birthdate;

	@Override
	public String execute() throws Exception {
		try {
			ServiceProvider.getService().update(edit_email,
					edit_password, edit_displayName,
					edit_firstName, edit_lastName, edit_gender,
					edit_birthdate, edit_postalCode,
					edit_houseNumber, edit_street, edit_city);

		} catch (AuctifyException e) {
			addFieldError("edit_password", e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		
		// Address validation
		
		if (edit_city == null) {
			addFieldError("edit_city", "city is required");
		} else if ("".equals(edit_city.trim())) {
			addFieldError("edit_city", "city is required");
		}
		
		if (edit_street == null) {
			addFieldError("edit_street", "street is required");
		} else if ("".equals(edit_street.trim())) {
			addFieldError("edit_street", "street is required");
		}
		
		if (edit_postalCode == null) {
			addFieldError("edit_postalCode", "postal code is required");
		} else if ("".equals(edit_postalCode.trim())) {
			addFieldError("edit_postalCode", "postal code is required");
		}
		
		if (edit_houseNumber == null) {
			addFieldError("edit_houseNumber", "house number is required");
		} else if ("".equals(edit_houseNumber.trim())) {
			addFieldError("edit_houseNumber", "house number is required");
		}
		
		// Person validation
		
		if (edit_birthdate == null) {
			addFieldError("edit_birthdate", "birthdate is required");
		} else if(!edit_birthdate.before(Calendar.getInstance().getTime())) {
			addFieldError("edit_birthdate", "birthdate cannot be in the future");
		}
		
		if (edit_gender != 0 && edit_gender != 1) {
			addFieldError("edit_gender", "gender is required");
		} 
		
		if (edit_lastName == null) {
			addFieldError("edit_lastName", "last name is required");
		} else if("".equals(edit_lastName.trim())) {
			addFieldError("edit_lastName", "last name is required");
		}
		
		if (edit_firstName == null) {
			addFieldError("edit_firstName", "first name is required");
		} else if("".equals(edit_firstName.trim())) {
			addFieldError("edit_firstName", "first name is required");
		}
		
		// User validation
		
		if (edit_displayName == null) {
			addFieldError("edit_displayName", "display name is required");
		} else if ("".equals(edit_displayName.trim())) {
			addFieldError("edit_displayName", "display name is required");
		}

		if (edit_email == null) {
			addFieldError("edit_email", "email is required");
		} else if ("".equals(edit_email.trim())) {
			addFieldError("edit_email", "email is required");
		}

		/*
		 * Temp. disabled password check!
		 * 
		 * if (edit_new_password != null) {
			
			if (edit_password == null) {
				addFieldError("edit_password", "password is required");
			}

			if (edit_password2 == null) {
				addFieldError("edit_password", "password is required");
			} else if ("".equals(edit_password.trim())) {
				addFieldError("edit_password", "retype password is required");
			} else if (!edit_password.equals(edit_password2)) {
				addFieldError("edit_password", "Passwords don't match");
			}
			
		}
		
		
		if (!hasFieldErrors()) {
		*/	User user = new User(edit_email, edit_password,
					edit_displayName, null);
			/*UserRegisterValidator urv = new UserRegisterValidator();
			List<AttributeError> userAttributeErrorsList = urv.validate(user);
			if (userAttributeErrorsList.size() > 0) {
				for (AttributeError ate : userAttributeErrorsList) {
					addFieldError("edit_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}*/
			
			Person person = new Person(edit_firstName, edit_lastName, edit_gender, edit_birthdate);
			UserPersonValidator upv = new UserPersonValidator();
			List<AttributeError> personAttributeErrorsList = upv.validate(person);
			if (personAttributeErrorsList.size() > 0) {
				for (AttributeError ate : personAttributeErrorsList) {
					addFieldError("edit_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}
			
			Address address = new Address(edit_postalCode, edit_houseNumber, edit_street, edit_city);
			UserAddressValidator uav = new UserAddressValidator();
			List<AttributeError> addressAttributeErrorsList = uav.validate(address);
			if (addressAttributeErrorsList.size() > 0) {
				for (AttributeError ate : addressAttributeErrorsList) {
					addFieldError("edit_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}
		//}
	}

	public String getEdit_email() {
		return edit_email;
	}

	public String getEdit_password() {
		return edit_password;
	}

	public void setEdit_email(String registerEmail) {
		this.edit_email = registerEmail;
	}

	public void setEdit_password(String registerPassword) {
		this.edit_password = registerPassword;
	}

	public String getEdit_password2() {
		return edit_password2;
	}

	public void setEdit_password2(String registerPassword2) {
		this.edit_password2 = registerPassword2;
	}

	public String getEdit_displayName() {
		return edit_displayName;
	}

	public void setEdit_displayName(String registerDisplayName) {
		this.edit_displayName = registerDisplayName;
	}

	public String getEdit_firstName() {
		return edit_firstName;
	}

	public void setEdit_firstName(String edit_firstName) {
		this.edit_firstName = edit_firstName;
	}

	public String getEdit_lastName() {
		return edit_lastName;
	}

	public void setEdit_lastName(String edit_lastName) {
		this.edit_lastName = edit_lastName;
	}

	

	public int getEdit_gender() {
		return edit_gender;
	}

	
	public void setEdit_gender(int edit_gender) {
		this.edit_gender = edit_gender;
	}
	@TypeConversion(converter="com.th5.struts.others.StringToDateTimeConverter")
	public Date getEdit_birthdate() {
		return edit_birthdate;
	}
	@TypeConversion(converter="com.th5.struts.others.StringToDateTimeConverter")
	public void setEdit_birthdate(Date edit_birthdate) {
		
		this.edit_birthdate = edit_birthdate;
	}

	public String getEdit_postalCode() {
		return edit_postalCode;
	}

	public void setEdit_postalCode(String edit_postalCode) {
		this.edit_postalCode = edit_postalCode;
	}

	public String getEdit_houseNumber() {
		return edit_houseNumber;
	}

	public void setEdit_houseNumber(String edit_houseNumber) {
		this.edit_houseNumber = edit_houseNumber;
	}

	public String getEdit_street() {
		return edit_street;
	}

	public void setEdit_street(String edit_street) {
		this.edit_street = edit_street;
	}

	public String getEdit_city() {
		return edit_city;
	}

	public void setEdit_city(String edit_city) {
		this.edit_city = edit_city;
	}
}
