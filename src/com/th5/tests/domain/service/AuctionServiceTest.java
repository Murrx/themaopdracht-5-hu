package com.th5.tests.domain.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;

public class AuctionServiceTest {
	
	public static AuctionServiceInterface service;
	
	@BeforeClass
	public static void getService(){
		service = ServiceProvider.getService();
	}
	
	
	@Test
	public void loginTest(){
		try {
			User user = service.login("admin", "admin");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	@Test (expected = AuctifyException.class)
	public void loginTestUnexistingUser() throws AuctifyException{
		User user = service.login("dakoika", "admin");
	}
	@Test (expected = AuctifyException.class)
	public void loginTestIncorrectPassword() throws AuctifyException{
		User user = service.login("admin", "test");
	}
}
