package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
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
		
		//String loginEmailRegex = "A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z\\S]{2,4}";
		
		if (registerEmail.trim().equals("")) {
			addFieldError("registerEmail", "email is required");
		}
		
		//else if (!email.matches(loginEmailRegex)) {
		//	addFieldError("email", "Invalid email");
		//}
		
		//The loginPasswordRegex checks if there is atleast:
		//- 1 digit or more.
		//- 1 Uppercase letter or more.
		//- 1 lowercase letter or more.
		//- 8 characters or more in the string.
		String loginPasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		
	    if (registerPassword.trim().equals("")) {
			addFieldError("registerPassword", "password is required");
		}
	    else if (!registerPassword.equals(registerPassword2)){
			addFieldError("registerPassword", "Passwords don't match");
		}
				
		else if (!registerPassword.matches(loginPasswordRegex)) {
			addFieldError("registerPassword", "Invalid password");
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
