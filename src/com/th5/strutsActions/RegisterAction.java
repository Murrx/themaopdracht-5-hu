package com.th5.strutsActions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.model.validators.AttributeError;
import com.th5.domain.model.validators.UserRegisterValidator;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

public class RegisterAction extends ActionSupport{

	private String registerEmail;
	private String registerPassword;
	private String registerPassword2;
	private String registerDisplayName;

	@Override
	public String execute() throws Exception {
		try {
			ServiceProvider.getService().register(registerEmail, registerPassword, registerDisplayName);
		} catch (AuctifyException e) {
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if (registerDisplayName.trim().equals("")) {
			addFieldError("registerDisplayName", "display name is required");
		}
		
		if (registerEmail.trim().equals("")) {
			addFieldError("registerEmail", "email is required");
		}
				
	    if (registerPassword.trim().equals("")) {
			addFieldError("registerPassword", "password is required");
		}
	    else if (!registerPassword.equals(registerPassword2)){
			addFieldError("registerPassword", "Passwords don't match");
		}
	    User user = new User(registerEmail, registerPassword, registerDisplayName, null);
		UserRegisterValidator urv = new UserRegisterValidator();
		List<AttributeError> attributeErrorsList = urv.validate(user);
		if (attributeErrorsList.size() > 0) {
			for (AttributeError ate : attributeErrorsList) {
		addFieldError("register_"+ate.getAttribute(), ate.getErrorMessage());
			}
		}
	}


	public String getRegisterEmail(){
		return registerEmail;
	}
	public String getRegisterPassword(){
		return registerPassword;
	}
	public void setRegisterEmail(String registerEmail){
		this.registerEmail = registerEmail;
	}
	public void setRegisterPassword(String registerPassword){
		this.registerPassword = registerPassword;
	}
	public String getRegisterPassword2() {
		return registerPassword2;
	}
	public void setRegisterPassword2(String registerPassword2) {
		this.registerPassword2 = registerPassword2;
	}
	public String getRegisterDisplayName() {
		return registerDisplayName;
	}
	public void setRegisterDisplayName(String registerDisplayName) {
		this.registerDisplayName = registerDisplayName;
	}
}
