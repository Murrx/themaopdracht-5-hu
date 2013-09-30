package com.th5.strutsActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.model.validators.AttributeError;
import com.th5.domain.model.validators.UserRegisterValidator;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {

	private String register_email;
	private String register_password;
	private String register_password2;
	private String register_displayName;

	@Override
	public String execute() throws Exception {
		try {
			ServiceProvider.getService().register(register_email,
					register_password, register_displayName);
		} catch (AuctifyException e) {
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {

		if (register_displayName == null) {
			addFieldError("register_displayName", "display name is required");
		} else if ("".equals(register_displayName.trim())) {
			addFieldError("register_displayName", "display name is required");
		}

		if (register_email == null) {
			addFieldError("register_email", "email is required");
		}
		else if ("".equals(register_email.trim())) {
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
		} else {
			
			User user = new User(register_email, register_password,
					register_displayName, null);
			UserRegisterValidator urv = new UserRegisterValidator();
			List<AttributeError> attributeErrorsList = urv.validate(user);
			if (attributeErrorsList.size() > 0) {
				for (AttributeError ate : attributeErrorsList) {
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
}
