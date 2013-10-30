package com.th5.tests.domain.other;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.UserDatabaseCRUD;

public class AuctionListManagerTest {
	static AuctionListManager am;
	static CRUD_Interface<User> uci;
	static CRUD_Interface<Auction> aci;
	private Auction auction;
	private static User user;

	@BeforeClass
	public static void oneTimeSetupBeforeClass() throws AuctifyException {
		am = new AuctionListManager();
		uci = new UserDatabaseCRUD();

		user = new User("auctionMangerTest", "Auctionmaneger1",
				"auctionManager", UserRights.USER);
		Calendar birthdate = Calendar.getInstance();
		birthdate.set(1990, 10, 10);
		user.setPerson(new Person("aaaa", "aaaaa", 1, birthdate.getTime()));
		user.setAddress(new Address("3333 HD", "73", "amsterdam", "amsterdam"));
		uci.create(user);
	}

	@Before
	public void setup() {
		Calendar eindTime = Calendar.getInstance();
		eindTime.set(2013, 12, 30);
		auction = new Auction(eindTime, 10, Category.CARS, "auto", "beep beep");
		auction.setUser(user);
	}

	@Test
	public void testCreate() {
		Calendar eindTime = Calendar.getInstance();
		eindTime.set(2013, 12, 30);
		try {
			int id = -1;
			id = am.create(auction);
			aci.delete(new Auction(id));
		} catch (AuctifyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRetrieve() {
		try {
			Calendar eindTime = Calendar.getInstance();
			eindTime.set(2013, 11, 30);
			int id = -1;
			id = am.create(auction);
			aci.delete(new Auction(id));
		} catch (AuctifyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDelete() {
		try {
			Calendar eindTime = Calendar.getInstance();
			eindTime.set(2013, 11, 30);
			int id = -1;
			id = am.create(auction);
			aci.delete(new Auction(id));
		} catch (AuctifyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRetriveAll() {
		try {
			aci.retrieveAll();
		} catch (AuctifyException e) {
			fail(e.getMessage());
		}
	}

	@AfterClass
	public static void oneTimeTearDown() throws AuctifyException {
		uci.delete(user);
	}

}
