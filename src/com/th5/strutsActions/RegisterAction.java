package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.service.ServiceProvider;

public class RegisterAction extends ActionSupport{

	String email;
	String password;

	@Override
	public String execute() throws Exception {
		boolean result = ServiceProvider.getService().register(email, password);
		if (result == false) return ActionSupport.ERROR;
		else return ActionSupport.SUCCESS;
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
