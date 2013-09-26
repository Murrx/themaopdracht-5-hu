package com.th5.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.th5.tests.domain.service.AuctionServiceTest;
import com.th5.tests.persistance.UserDatabaseCRUD_Test;

@RunWith(Suite.class)
@SuiteClasses
({ 
	//Domain tests
	AuctionServiceTest.class,
	
	//Persistance tests
	UserDatabaseCRUD_Test.class
})
public class AllTests {

}
