package com.th5.strutsActions;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.User;
import com.th5.domain.service.ServiceProvider;

public class RegisterAction extends ActionSupport{

	String username;
	String password;

	@Override
	public String execute() throws Exception {
		boolean result = ServiceProvider.getService().register(username, password);
		if (result == false) return ActionSupport.ERROR;
		else return ActionSupport.SUCCESS;
	}


	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}
}
