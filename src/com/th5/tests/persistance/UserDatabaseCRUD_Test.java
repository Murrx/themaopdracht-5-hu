package com.th5.tests.persistance;

import static org.junit.Assert.*;

import org.junit.Test;

import com.th5.domain.other.AuctifyException;
import com.th5.persistance.UserDatabaseCRUD;

public class UserDatabaseCRUD_Test {

	@Test
	public void testRetrieve() throws AuctifyException {
		UserDatabaseCRUD crud = new UserDatabaseCRUD();
		crud.retrieve("testaccount@auctify.com");
	}
	
	@Test (expected = AuctifyException.class)
	public void testRetrieveInvallidUser() throws AuctifyException {
		UserDatabaseCRUD crud = new UserDatabaseCRUD();
		crud.retrieve("testaccount@auctify.nl");
	}

}
