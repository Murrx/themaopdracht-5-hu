package com.th5.domain.model;

import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;


public class User implements Comparable<User>{

	private int 	userId,
					bidCoins;
	private String 	email,
					password, 
					displayName;
	
	private Person 	person;
	private Address	address;
	private UserRights rights;
	private AuctionListManager auctionManager;
	
	public User(String email){
		this.email = email;
	}
	public User(String email,String password, String displayName, UserRights rights){
		this(email);
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
		this.auctionManager = new AuctionListManager();
		this.bidCoins = 0;
	}
	public User(int userId, String email, String password, String displayName, UserRights rights, int bidCoins){
		this(email, password, displayName, rights);
		this.userId = userId;
		this.bidCoins = bidCoins;
	}
	
	public int createAuction(Auction auction) throws AuctifyException{
		auction.setUserId(this.userId);
		int auctionId = auctionManager.create(auction);
		
		return auctionId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public boolean equals(Object obj) {
		User otherUser = (User)obj;
		boolean equals = true;
		equals = equals && email.equals(otherUser.email);
		equals = equals && password.equals(otherUser.password);
		System.out.println(equals);
		return equals;
	}
	@Override
	public int compareTo(User user) {
		return email.compareTo(user.email);
	}
	@Override
	public String toString() {
		return userId+ " " + email + " " + password + " " + displayName + " " + rights + " " + bidCoins;
	}
	public String getDisplayName(){
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public UserRights getRights(){
		return rights;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	/**
	 * Returns the users' BidcCoins
	 * 
	 * @see #addBidCoins
	 * @see #takeBidCoins
	 */
	public int getBidCoins() {
		return this.bidCoins;
	}
	
	/**
	 * Increments the users' BidCoins by a certain amount.
	 * 
	 * @param amount Number of BidCoins to increment with
	 * @see #getBidCoins
	 * @see #takeBidCoins
	 */
	public void addBidCoins (int amount) {
		this.bidCoins += amount;
	}
	
	/**
	 * Decrements the users' BidCoins by a certain amount.
	 * 
	 * @param amount Number of BidCoins to decrement with
	 * @see #getBidCoins
	 * @see #addBidCoins
	 */
	public void takeBidCoins (int amount) {
		this.bidCoins -= amount;
	}
}
