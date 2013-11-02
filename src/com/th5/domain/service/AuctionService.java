package com.th5.domain.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.EncryptPassword;
import com.th5.domain.util.SortedArrayList;
import com.th5.domain.util.UserListManager;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.UserDatabaseCRUD;

public class AuctionService implements AuctionServiceInterface {

	private UserDatabaseCRUD udbcrud = new UserDatabaseCRUD();
	private UserListManager userList;
	private List<Auction> allAuctions;

	public AuctionService() {
		userList = new UserListManager();
		allAuctions = retrieveAllAuctions();
	}

	/**
	 * Retrieve all auctions from database
	 * 
	 * @return List<Auction> with all auctions
	 */
	private List<Auction> retrieveAllAuctions() {
		List<Auction> auctions = new SortedArrayList<Auction>();
		try {
			AuctionDatabaseCRUD dbCRUD = new AuctionDatabaseCRUD();
			List<Auction> tempList = dbCRUD.retrieveAll();
			for (Auction auction : tempList) {
				auctions.add(auction);
			}
		} catch (AuctifyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return auctions;
	}

	/**
	 * Attempt to get an auction from allAuctions
	 * 
	 * @param auctionId
	 * @return the auction. returns null when auction is not found
	 */
	public Auction getAuctionById(int auctionId) {
		Auction auction = null;
		int index = Collections.binarySearch(allAuctions, new Auction(auctionId));
		if (index >= 0) {
			auction = allAuctions.get(index);
		}
		return auction;
	}

	public List<Auction> getAllAuctions() {
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

	public User getUserById(int id) throws AuctifyException {
		User user = userList.retrieveById(id);
		return user;
	}

	public List<Auction> getPopularAuctions() {
		int amountToReturn = 3;
		if(allAuctions.size() < amountToReturn){
			return allAuctions;
		}
		List<Auction> popularAuctions = (allAuctions).subList(0, amountToReturn);
		return popularAuctions;
	}

	public List<Auction> getLatestAuctions() {
		int amountToReturn = 4;
		if(allAuctions.size() < amountToReturn){
			return allAuctions;
		}
		List<Auction> latestAuctions = (allAuctions).subList(allAuctions.size() - amountToReturn, allAuctions.size());
		return latestAuctions;
	}
	
	public List<Bid> getLatestBids(){
		
		List<Bid> latestBids = null;
		
		return latestBids;
		
	}

}
