package com.th5.struts.actions;

import java.util.Calendar;
import java.util.List;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.th5.domain.model.Address;
import com.th5.domain.model.User;
import com.th5.domain.model.validators.AttributeError;
import com.th5.domain.model.validators.UserAddressValidator;
import com.th5.domain.model.validators.UserRegisterValidator;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

@Conversion()
@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {

	private String  register_email, 
					register_password, 
					register_password2,
					register_displayName,
		
					register_firstName, 
					register_lastName,
				
					register_postalCode, 
					register_houseNumber, 
					register_street,
					register_city;
	
	private int 	register_gender;
	private Date	register_birthdate;

	@Override
	public String execute() throws Exception {
		try {
			ServiceProvider.getService().register(register_email,
					register_password, register_displayName,
					register_firstName, register_lastName, register_gender,
					register_birthdate, register_postalCode,
					register_houseNumber, register_street, register_city);

		} catch (AuctifyException e) {
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		
		// Address validation
		
		if (register_city == null) {
			addFieldError("register_city", "city is required");
		} else if ("".equals(register_city.trim())) {
			addFieldError("register_city", "city is required");
		}
		
		if (register_street == null) {
			addFieldError("register_street", "street is required");
		} else if ("".equals(register_street.trim())) {
			addFieldError("register_street", "street is required");
		}
		
		if (register_postalCode == null) {
			addFieldError("register_postalCode", "postal code is required");
		} else if ("".equals(register_postalCode.trim())) {
			addFieldError("register_postalCode", "postal code is required");
		}
		
		if (register_houseNumber == null) {
			addFieldError("register_houseNumber", "house number is required");
		} else if ("".equals(register_houseNumber.trim())) {
			addFieldError("register_houseNumber", "house number is required");
		}
		
		// Person validation
		
		if (register_birthdate == null) {
			addFieldError("register_birthdate", "birthdate is required");
		} else if(!register_birthdate.before(Calendar.getInstance().getTime())) {
			addFieldError("register_birthdate", "birthdate is required");
		}
		
		if (register_gender == 0 || register_gender == 1) {
			addFieldError("register_gender", "gender is required");
		} 
		
		if (register_lastName == null) {
			addFieldError("register_lastName", "last name is required");
		} else if("".equals(register_lastName.trim())) {
			addFieldError("register_lastName", "last name is required");
		}
		
		if (register_firstName == null) {
			addFieldError("register_firstName", "first name is required");
		} else if("".equals(register_firstName.trim())) {
			addFieldError("register_firstName", "first name is required");
		}
		
		// User validation
		
		if (register_displayName == null) {
			addFieldError("register_displayName", "display name is required");
		} else if ("".equals(register_displayName.trim())) {
			addFieldError("register_displayName", "display name is required");
		}

		if (register_email == null) {
			addFieldError("register_email", "email is required");
		} else if ("".equals(register_email.trim())) {
			addFieldError("register_email", "email is required");
		}

		if (register_password == null) {
			addFieldError("register_password", "password is required");
		}

		if (register_password2 == null) {
			addFieldError("register_password", "password is required");
		} else if ("".equals(register_password.trim())) {
			addFieldError("register_password", "retype password is required");
		} else if (!register_password.equals(register_password2)) {
			addFieldError("register_password", "Passwords don't match");
		} 

//			Person person = new Person();  -- TODO::
//			Address address = new Address();
			
		if (!hasFieldErrors()) {
			User user = new User(register_email, register_password,
					register_displayName, null);
			UserRegisterValidator urv = new UserRegisterValidator();
			List<AttributeError> userAttributeErrorsList = urv.validate(user);
			if (userAttributeErrorsList.size() > 0) {
				for (AttributeError ate : userAttributeErrorsList) {
					addFieldError("register_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}
			
			Address address = new Address(register_postalCode, register_houseNumber, register_street, register_city);
			UserAddressValidator uav = new UserAddressValidator();
			List<AttributeError> addressAttributeErrorsList = uav.validate(address);
			if (addressAttributeErrorsList.size() > 0) {
				for (AttributeError ate : addressAttributeErrorsList) {
					addFieldError("register_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}
		}
	}

	public String getRegister_email() {
		return register_email;
	}

	public String getRegister_password() {
		return register_password;
	}

	public void setRegister_email(String registerEmail) {
		this.register_email = registerEmail;
	}

	public void setRegister_password(String registerPassword) {
		this.register_password = registerPassword;
	}

	public String getRegister_password2() {
		return register_password2;
	}

	public void setRegister_password2(String registerPassword2) {
		this.register_password2 = registerPassword2;
	}

	public String getRegister_displayName() {
		return register_displayName;
	}

	public void setRegister_displayName(String registerDisplayName) {
		this.register_displayName = registerDisplayName;
	}

	public String getRegister_firstName() {
		return register_firstName;
	}

	public void setRegister_firstName(String register_firstName) {
		this.register_firstName = register_firstName;
	}

	public String getRegister_lastName() {
		return register_lastName;
	}

	public void setRegister_lastName(String register_lastName) {
		this.register_lastName = register_lastName;
	}

	

	public int getRegister_gender() {
		return register_gender;
	}

	
	public void setRegister_gender(int register_gender) {
		this.register_gender = register_gender;
	}
	@TypeConversion(converter="com.th5.struts.others.StringToDateTimeConverter")
	public Date getRegister_birthdate() {
		return register_birthdate;
	}
	@TypeConversion(converter="com.th5.struts.others.StringToDateTimeConverter")
	public void setRegister_birthdate(Date register_birthdate) {
		
		this.register_birthdate = register_birthdate;
	}

	public String getRegister_postalCode() {
		return register_postalCode;
	}

	public void setRegister_postalCode(String register_postalCode) {
		this.register_postalCode = register_postalCode;
	}

	public String getRegister_houseNumber() {
		return register_houseNumber;
	}

	public void setRegister_houseNumber(String register_houseNumber) {
		this.register_houseNumber = register_houseNumber;
	}

	public String getRegister_street() {
		return register_street;
	}

	public void setRegister_street(String register_street) {
		this.register_street = register_street;
	}

	public String getRegister_city() {
		return register_city;
	}

	public void setRegister_city(String register_city) {
		this.register_city = register_city;
	}
}
