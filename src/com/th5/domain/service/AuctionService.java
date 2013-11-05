package com.th5.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.BidStatus;
import com.th5.domain.model.Person;
import com.th5.domain.model.Status;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.EncryptPassword;
import com.th5.domain.other.RefreshAuctionsTimer;
import com.th5.domain.util.LazyMap;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.UserDatabaseCRUD;
import com.th5.persistance.queries.Queries;

public class AuctionService implements AuctionServiceInterface {

	private UserDatabaseCRUD udbcrud = new UserDatabaseCRUD();
	private LazyMap<String, User> userMap;
	private TreeMap<String, Auction> allAuctions;
	private TreeMap<String, Bid> allBids;
	private RefreshAuctionsTimer timer;
	
	public AuctionService() {
		userMap = new LazyMap<>(true, udbcrud);
		allAuctions = retrieveAllAuctions();
		allBids = retrieveAllBids();
		// timer = new RefreshAuctionsTimer();
	}

	/**
	 * Retrieve all auctions from database
	 * 
	 * @return List<Auction> with all auctions
	 */
	private TreeMap<String, Auction> retrieveAllAuctions() {
		TreeMap<String, Auction> auctions = new TreeMap<String, Auction>();
		try {
			AuctionDatabaseCRUD dbCRUD = new AuctionDatabaseCRUD();
			List<Auction> tempList = dbCRUD.retrieve(null,
					Queries.selectAllAuctions);
			for (Auction auction : tempList) {
				auctions.put(auction.getIdentifier(), auction);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return auctions;
	}

	private TreeMap<String, Bid> retrieveAllBids() {
		TreeMap<String, Bid> allBids = new TreeMap<String, Bid>();

		try {
			BidDatabaseCRUD dbCRUD = new BidDatabaseCRUD();
			List<Bid> tempList = dbCRUD.retrieve(null, Queries.selectAllBids);
			List<Auction> tempAuctionList = new ArrayList<Auction>();
			if (tempList != null) {

				for (Bid bid : tempList) {

					Auction tempAuction = getAuctionById(bid.getAuctionId());

					tempAuctionList.add(tempAuction);

					if (tempAuction.getStatus() == Status.ACTIVE) {
						bid.setBidStatus(BidStatus.LOSING);

					} else {
						bid.setBidStatus(BidStatus.LOST);

					}
					bid.setAuction(tempAuction);

					allBids.put(bid.getIdentifier(), bid);
				}
				
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

	public Map<String, Bid> getAllBids() {
		return allBids;
	}

	public Map<String, Auction> getAllAuctions() {
		return allAuctions;
	}

	@Override
	public User login(String email, String password) throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);
		User user = userMap.get(email);
		if (user == null || !user.getPassword().equals(password)) {
			throw new AuctifyException("Username op password incorrect");
		}
		if (user.getRights().getRightsValue() < 5) {
			throw new AuctifyException("User is blocked.");
		}
		user.register(udbcrud);
		return user;
	}

	@Override
	public void register(String email, String password, String displayName,
			String firstName, String lastName, int gender, Date birthdate,
			String postalCode, String houseNumber, String street, String city)
			throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);

		Person person = new Person(firstName, lastName, gender, birthdate);
		Address address = new Address(postalCode, houseNumber, street, city);
		User user = new User(email, password, displayName, UserRights.USER);

		user.setAddress(address);
		user.setPerson(person);

		userMap.put(user.getIdentifier(), user);
	}

	@Override
	public void update(String email, String password, String displayName,
			String firstName, String lastName, int gender, Date birthdate,
			String postalCode, String houseNumber, String street, String city)
			throws AuctifyException {
		password = EncryptPassword.encryptPassword(password);

		User user = userMap.get(email);

		Person person = new Person(firstName, lastName, gender, birthdate);
		Address address = new Address(postalCode, houseNumber, street, city);

		user.setEmail(email);
		user.setPassword(password);
		user.setDisplayName(displayName);

		user.setAddress(address);
		user.setPerson(person);

		udbcrud.update(user);
	}

	public User getUserById(String identifier) {
		return userMap.get(identifier);
	}

	public List<Auction> getPopularAuctions() {
		int amountToReturn = 3;
		List<Auction> latestAuctions = new ArrayList<>();
		int i = 0;
		for (Entry<String, Auction> auction : allAuctions.descendingMap()
				.entrySet()) {
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
		for (Entry<String, Auction> auction : allAuctions.descendingMap()
				.entrySet()) {
			if (i++ < amountToReturn) {
				latestAuctions.add(auction.getValue());
			}
		}
		return latestAuctions;
	}

	public List<Bid> getLatestBids() {

		int amountToReturn = 9;

		List<Bid> latestBids = new ArrayList<>();
		int i = 0;
		for (Entry<String, Bid> bid : allBids.descendingMap().entrySet()) {
			if (i++ < amountToReturn) {
				latestBids.add(bid.getValue());
			}
		}
		return latestBids;
	}

	public Map<String, User> getUserMap() {
		return userMap;
	}

	@Override
	public void refreshAllAuctions(){
		for(Auction auction : allAuctions.values()){
			if(auction.getStatus().getRightsValue() >= 2 ){
				try {
					auction.refreshStatus();
				} catch (AuctifyException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
