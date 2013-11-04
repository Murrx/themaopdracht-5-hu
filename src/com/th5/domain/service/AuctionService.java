package com.th5.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.EncryptPassword;
import com.th5.domain.util.UserListManager;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.UserDatabaseCRUD;
import com.th5.persistance.queries.Queries;

public class AuctionService implements AuctionServiceInterface {

	private UserDatabaseCRUD udbcrud = new UserDatabaseCRUD();
	private UserListManager userList;
	private TreeMap<String,Auction> allAuctions;
	private HashMap<String, Bid> allBids;

	public AuctionService() {
		userList = new UserListManager();
		allAuctions = retrieveAllAuctions();
		allBids = retrieveAllBids();
		System.out.println(allBids);
	}

	/**
	 * Retrieve all auctions from database
	 * 
	 * @return List<Auction> with all auctions
	 */
	private TreeMap<String,Auction> retrieveAllAuctions() {
		TreeMap<String,Auction> auctions = new TreeMap<String,Auction>();
		try {
			AuctionDatabaseCRUD dbCRUD = new AuctionDatabaseCRUD();
			List<Auction> tempList = dbCRUD.retrieve(null, Queries.selectAllAuctions);
			for (Auction auction : tempList) {
				auctions.put(auction.getIdentifier(),auction);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return auctions;
	}
	
	private HashMap<String, Bid> retrieveAllBids(){
		HashMap<String,Bid> allBids = new HashMap<String,Bid>();
		
		try {
			BidDatabaseCRUD dbCRUD = new BidDatabaseCRUD();
			List<Bid> tempList = dbCRUD.retrieve(null, Queries.selectAllBids);
			for (Bid bid : tempList) {
				allBids.put(bid.getIdentifier(),bid);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return allBids;
	}

	/**
	 * Attempt to get an auction from allAuctions
	 * 
	 * @param auctionId
	 * @return the auction. returns null when auction is not found
	 */
	public Auction getAuctionById(int auctionId) {
		return allAuctions.get(Integer.toString(auctionId));
	}
	
	public Map<String, Bid> getAllBids(){
		return allBids;
	}

	public Map<String,Auction> getAllAuctions() {
		return allAuctions;
	}

	@Override
	public User login(String email, String password) throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);
		User user = userList.retrieve(email);
		if (user == null || !user.getPassword().equals(password)) {
			throw new AuctifyException("Username op password incorrect");
		}
		user.register(udbcrud);
		return user;
	}

	@Override
	public void register(String email, String password, String displayName, String firstName, String lastName, int gender, Date birthdate, String postalCode,
			String houseNumber, String street, String city) throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);

		Person person = new Person(firstName, lastName, gender, birthdate);
		Address address = new Address(postalCode, houseNumber, street, city);
		User user = new User(email, password, displayName, UserRights.USER);

		user.setAddress(address);
		user.setPerson(person);

		userList.create(user);
	}

	@Override
	public void update(String email, String password, String displayName, String firstName, String lastName, int gender, Date birthdate, String postalCode,
			String houseNumber, String street, String city) throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);

		User u = userList.retrieve(email);

		Person person = new Person(firstName, lastName, gender, birthdate);
		Address address = new Address(postalCode, houseNumber, street, city);

		u.setEmail(email);
		u.setPassword(password);
		u.setDisplayName(displayName);

		u.setAddress(address);
		u.setPerson(person);

		udbcrud.update(u);
	}

	public User getUserById(String identifier) throws AuctifyException {
		User user = userList.retrieveById(identifier);
		return user;
	}

	public List<Auction> getPopularAuctions() {
		int amountToReturn = 3;
		List<Auction> latestAuctions = new ArrayList<>();
		int i = 0;
		for (Entry<String, Auction> auction: allAuctions.descendingMap().entrySet()) {
		    if (i++ < amountToReturn) {
		        latestAuctions.add(auction.getValue());
		    }
		}
		return latestAuctions;
	}

	public List<Auction> getLatestAuctions() {
		int amountToReturn = 4;
		List<Auction> latestAuctions = new ArrayList<>();
		int i = 0;
		for (Entry<String, Auction> auction: allAuctions.descendingMap().entrySet()) {
		    if (i++ < amountToReturn) {
		        latestAuctions.add(auction.getValue());
		    }
		}
		return latestAuctions;
	}
	
	public List<Bid> getLatestBids(){
		
		List<Bid> latestBids = null;
		
		return latestBids;
		
	}

}
