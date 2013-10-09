package com.th5.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;
import com.th5.domain.other.AuctifyException;


public interface AuctionServiceInterface {
	
	/**Login a user with the given username and password
	 * @param email
	 * @param password
	 * @return the user object if login is succesfull
	 * @throws AuctifyException with a message describing the error, when login fails
	 */
	public User login(String email, String password) throws AuctifyException;	
	
	/** Register a new user with the given parameters
	 * @param email
	 * @param password
	 * @param displayName
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param birthdate
	 * @param postalCode
	 * @param houseNumber
	 * @param street
	 * @param city
	 * @throws AuctifyException when registration fails
	 */
	public void register(String email, String password, String displayName, String firstName, String lastName, int gender, Date birthdate, String postalCode, String houseNumber, String street, String city) throws AuctifyException;
	
	/** Retrieve all auctions on Auctify
	 * @throws AuctifyException 
	 */
	public ArrayList<Auction> getAllAuctions() throws AuctifyException;	

}
