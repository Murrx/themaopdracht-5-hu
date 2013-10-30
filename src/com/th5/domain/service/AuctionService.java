package com.th5.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Person;
import com.th5.domain.model.User;

import org.apache.commons.codec.digest.DigestUtils;

import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;
import com.th5.domain.other.UserListManager;
import com.th5.persistance.AuctionDatabaseCRUD;

public class AuctionService implements AuctionServiceInterface{

	private UserListManager userList;
	//private AuctionManager auctionList;
	
	public AuctionService(){
		userList = new UserListManager();
		//auctionList = new AuctionManager();
	}
	
	
	/**Gets all auctions
	 * @return ArrayList<Auction> with all auctions
	 * @throws AuctifyException when no auctions found.
	 */
	public ArrayList<Auction> getAllAuctions() throws AuctifyException {
		AuctionDatabaseCRUD adc = new AuctionDatabaseCRUD();
		return adc.retrieveAll();
	}
	
	/**Encrypts a password to sha512hex
	 * @param password
	 * @return the encrypted password
	 */
	private String encryptPassword (String password) {
		return DigestUtils.sha512Hex( password );
	}
	
	
	@Override
	public User login(String email, String password) throws AuctifyException {
		password = encryptPassword(password);
		User user = userList.retrieve(email);
		if (user == null || !user.getPassword().equals(password)){
			throw new AuctifyException("Username op password incorrect");	
		}
		return user;
	}
	
	@Override
	public void register(String email, String password, String displayName, String firstName, String lastName, int gender, Date birthdate, String postalCode, String houseNumber, String street, String city) throws AuctifyException{
		password = encryptPassword(password);
		
		Person person = new Person(firstName, lastName, gender, birthdate);
		Address address = new Address(postalCode, houseNumber, street, city);
		User user = new User(email, password, displayName, UserRights.USER);
		
		user.setAddress(address);
		user.setPerson(person);
		
		userList.create(user);
	}
	
	public User getUser(int id) {
		return userList.getUserFromUserList(id);
	}
	
}
