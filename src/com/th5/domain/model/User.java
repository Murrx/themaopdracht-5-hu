package com.th5.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.AuctionListManager;


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
		auction.setUser(this);
		int auctionId = auctionManager.create(auction);
		return auctionId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		this.changed = true;
		notifyObservers();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		this.changed = true;
		notifyObservers();
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
		this.changed = true;
		notifyObservers();
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		this.changed = true;
		notifyObservers();
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
		this.changed = true;
		notifyObservers();
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
		this.changed = true;
		notifyObservers();
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
		this.changed = true;
		notifyObservers();
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
	public void notifyObservers() {
		System.out.println("NotifyObservers");
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
			obs.updateObserver(this);
		}
		
	}
	@Override
	public Object getUpdate(Observer obs) {
		// TODO Auto-generated method stub
		return (User) this;
	}
}
