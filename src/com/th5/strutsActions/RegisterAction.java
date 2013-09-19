package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.service.ServiceProvider;

public class RegisterAction extends ActionSupport{

	private String email;
	private String password;

	@Override
	public String execute() throws Exception {
		boolean result = ServiceProvider.getService().register(email, password);
		if (result == false) return ActionSupport.ERROR;
		else return ActionSupport.SUCCESS;
	}
	
	@Override
	public void validate() {
		
		String loginEmailRegex = "A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z\\S]{2,4}";
		
		if (email.trim().equals("")) {
			addFieldError("email", "email is required");
		}
		
		else if (!email.matches(loginEmailRegex)) {
			addFieldError("username", "Invalid username");
		}
		
		String loginPasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		
	    if (password.trim().equals("")) {
			addFieldError("password", "password is required");
		}
				
		else if (!password.matches(loginPasswordRegex)) {
			addFieldError("password", "Invalid password");
		}
	}


	public String getEmail(){
		return email;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setPassword(String password){
		this.password = password;
	}
}
