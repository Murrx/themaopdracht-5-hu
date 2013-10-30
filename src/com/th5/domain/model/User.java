package com.th5.domain.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;
import com.th5.persistance.DataSourceService;


public class User implements Comparable<User>, Observable{

	private int 	userId,
					bidCoins;
	private String 	email,
					password, 
					displayName;
	
	private Person 	person;
	private Address	address;
	private UserRights rights;
	private AuctionListManager auctionManager;
	private List<Observer> observers;
    private final Object MUTEX= new Object();
    private boolean changed;
	
	public User(String email){
		this.email = email;
		this.auctionManager = new AuctionListManager();
		this.bidCoins = 0;
		this.observers = new ArrayList<Observer>();
	}
	public User(String email,String password, String displayName, UserRights rights){
		this(email);
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
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
	public void setPassword(String password) throws AuctifyException {
		try {
			this.password = password;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			throw new AuctifyException(e.getMessage());
		}
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws AuctifyException {
		try {
			this.email = email;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			throw new AuctifyException(e.getMessage());
		}
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) throws AuctifyException {
		try {
			this.person = person;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			throw new AuctifyException(e.getMessage());
		}
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) throws AuctifyException {
		try {
			this.address = address;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			throw new AuctifyException(e.getMessage());
		}
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
	
	public void setDisplayName(String displayName) throws AuctifyException {
		try {
			this.displayName = displayName;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			throw new AuctifyException(e.getMessage());
		}
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
	public void addBidCoins (int amount) throws AuctifyException {
		try {
			this.bidCoins += amount;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.bidCoins -= amount;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}
	
	/**
	 * Decrements the users' BidCoins by a certain amount.
	 * 
	 * @param amount Number of BidCoins to decrement with
	 * @throws AuctifyException 
	 * @see #getBidCoins
	 * @see #addBidCoins
	 */
	public void takeBidCoins (int amount) throws AuctifyException {
		try {
			this.bidCoins -= amount;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.bidCoins += amount;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}
	
	@Override
	public void register(Observer obs) {
		System.out.println("Register obs");

		if(obs == null) throw new NullPointerException("Observer is Null");
		if(!observers.contains(obs)) observers.add(obs);
	}
	@Override
	public void unregister(Observer obs) {
		// TODO Auto-generated method stub
        observers.remove(obs);
		
	}
	@Override
	public void notifyObservers() throws AuctifyException{
		// TODO Auto-generated method stub
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obs : observersLocal) {
			try {
				obs.updateObserver(this);
			} catch (AuctifyException e) {
				throw new AuctifyException(e.getMessage());
			}
			
		}
		
	}
	@Override
	public Object getUpdate(Observer obs) {
		return (User) this;
	}
}
