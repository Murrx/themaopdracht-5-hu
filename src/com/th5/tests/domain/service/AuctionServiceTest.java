package com.th5.tests.domain.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.persistance.UserDatabaseCRUD;
import com.th5.persistance.queries.Queries;

public class AuctionServiceTest {
	
	public static AuctionServiceInterface service;
	
	@BeforeClass
	public static void getService(){
		service = ServiceProvider.getService();
	}
	
	
	@Test
	public void loginTest(){
		try {
			User user = service.login("testaccount@auctify.com", "Apenbeestje1");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected = AuctifyException.class)
	public void loginTestUnexistingUser() throws AuctifyException{
		User user = service.login("dakoika", "Apenbeestje1");
	}
	
	@Test (expected = AuctifyException.class)
	public void loginTestIncorrectPassword() throws AuctifyException{
		User user = service.login("testaccount@auctify.com", "test");
	}
	
	@Test
	public void registerTest(){
		try {
			service.register("testaccount2@auctify.com", "Apenbeestje1", "Test Account", "Test voornaam", "Test achternaam", 1, new Date(0), "1111TT", "2", "Test", "Test");
		} catch (AuctifyException e) {
			fail("Failed to register user");
		}
		UserDatabaseCRUD crud = new UserDatabaseCRUD();
		
		User user = null;
		
		try {
			List<User> result = crud.retrieve("testaccount2@auctify.com", Queries.selectUserByEmail);
			if (result.isEmpty())fail("failed to retrieve user"); 

		} catch (AuctifyException e) {
			fail("failed to retrieve user");
		}
				
		try {
			crud.delete(user.getUserId());
		} catch (AuctifyException e) {
			fail("failed to delete user");
		}
	}
}
