package com.th5.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.th5.tests.domain.model.validators.AddAuctionValidatorTest;
import com.th5.tests.domain.model.validators.UserAddressValidatorTest;
import com.th5.tests.domain.model.validators.UserPersonValidatorTest;
import com.th5.tests.domain.model.validators.UserRegisterValidatorTest;
import com.th5.tests.domain.other.UserListManagerTest;
import com.th5.tests.domain.service.AuctionServiceTest;
import com.th5.tests.persistance.UserDatabaseCRUD_Test;

@RunWith(Suite.class)
@SuiteClasses
({ 
	//Domain tests
	AuctionServiceTest.class,
	UserListManagerTest.class,
	UserRegisterValidatorTest.class,
	UserAddressValidatorTest.class,
	UserPersonValidatorTest.class,
	AddAuctionValidatorTest.class,
	
	//Persistance tests
	UserDatabaseCRUD_Test.class
})
public class AllTests {

}
