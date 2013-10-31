package com.th5.tests.domain.other;

import static org.junit.Assert.fail;

import java.util.ArrayList;
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
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.UserDatabaseCRUD;

public class AuctionListManagerTest {
	
	private static CRUD_Interface<User> uci = new UserDatabaseCRUD();
	private static CRUD_Interface<Auction> aci = new AuctionDatabaseCRUD();
	private static Auction auction;
	private static User user = new User("auctionMangerTest", "Auctionmaneger1",
			"auctionManager", UserRights.USER);
	private static AuctionListManager am = user.getActionListManager();
	@BeforeClass
	public static void oneTimeSetupBeforeClass() throws AuctifyException {
		Calendar birthdate = Calendar.getInstance();
		birthdate.set(1990, 10, 10);
		user.setPerson(new Person("aaaa", "aaaaa", 1, birthdate.getTime()));
		user.setAddress(new Address("3333 HD", "73", "amsterdam", "amsterdam"));
		uci.create(user);
		am.setUser(user);
		Calendar eindTime = Calendar.getInstance();
		eindTime.set(2099, 12, 30);
		auction = new Auction(eindTime, 10, Category.CARS, "auto", "beep beep");
		auction.setOwner(user);
	}

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		am.clearAuctionList();
	}
	
	@Test
	public void testRetrieveAllUserAuctions() throws AuctifyException {
		int id = -1;
		id = am.create(auction);
		aci.delete(new Auction(id));
		int id2 = -1;
		id2 = am.create(auction);
		aci.delete(new Auction(id2));
		
		ArrayList<Auction> auctionList = am.getAuctionList();
		
		if (!(auctionList.size() == 2)) {
			System.out.println("a " + auctionList.size());
			fail("auctionList does not contain 2 auctions");
		}
	}

	@Test
	public void testCreate() throws AuctifyException {
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
