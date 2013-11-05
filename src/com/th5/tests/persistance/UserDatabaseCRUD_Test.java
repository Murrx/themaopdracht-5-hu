package com.th5.tests.persistance;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.UserDatabaseCRUD;
import com.th5.persistance.queries.Queries;

public class UserDatabaseCRUD_Test {

	@Test
	public void testRetrieve() throws AuctifyException {
		UserDatabaseCRUD crud = new UserDatabaseCRUD();
		List<User> result = crud.retrieve("testaccount@auctify.com", Queries.selectUserByEmail);
		if(result.isEmpty())fail("failed to retrieve user");
	}
	
	@Test
	public void testRetrieveInvallidUser() throws AuctifyException {
		UserDatabaseCRUD crud = new UserDatabaseCRUD();
		List<User> result = crud.retrieve("testaccount@auctify.nl", Queries.selectUserByEmail);
		if (!result.isEmpty())fail("Returned a user while this should not have happend");
	}

}
