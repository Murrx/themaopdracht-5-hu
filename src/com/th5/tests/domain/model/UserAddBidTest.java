package com.th5.tests.domain.model;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;

public class UserAddBidTest {

	@Test
	public void test() {
		
	
		
		User u = new User(1,"test@test.com","test", "admin", UserRights.ADMIN, 3000);
		
		try{
		u.bidOnAuction(183, 20);
		
		Auction auction = ServiceProvider.getService().getAuctionById(183);
		
	
		
		} catch(AuctifyException e){
			e.printStackTrace();
			fail("Not enough bidcoins on user");
		}
		
		
	
	}

}
