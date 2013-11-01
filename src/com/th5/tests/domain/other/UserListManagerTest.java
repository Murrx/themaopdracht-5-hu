package com.th5.tests.domain.other;

import org.junit.BeforeClass;
import org.junit.Test;

import com.th5.domain.other.AuctifyException;
import com.th5.domain.util.UserListManager;

public class UserListManagerTest {
	static UserListManager ulm;

	@BeforeClass
	public static void setup(){
		ulm = new UserListManager();
	}

	@Test
	public void testRetrieve() throws AuctifyException {
		ulm.retrieve("testaccount@auctify.com");
	}
	@Test (expected = AuctifyException.class)
	public void testRetrieveEmailDontExcist() throws AuctifyException {
		ulm.retrieve("testaccount@auctify.nl");
	}
}