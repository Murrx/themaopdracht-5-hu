package com.th5.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.SyncedMap;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.queries.Queries;

/**themaopdracht5 - Auctify
 * @author GarbageCollectors 2.0 (Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
 * 
 * Contains the most data about a user of Auctify.
 * Further data about a user is stored in Person and Address 
 */
public class User implements Comparable<User>, Observable, Identifiable<String>, IdentifiableByEmail<String>{

	private int userId, bidCoins;
	private String email, password, displayName;
	private SyncedMap<String, Auction> myAuctions;
	private SyncedMap<String, Bid> myBids;

	private Person person;
	private Address address;
	private UserRights rights;
	private List<Observer> observers;
	private final Object MUTEX = new Object();
	private boolean changed;

	@Deprecated
	public User(String email) {
		this.email = email;
		this.bidCoins = 0;
		this.observers = new ArrayList<Observer>();
	}

	@Deprecated
	public User(String email, String password, String displayName,
			UserRights rights) {
		this(email);
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
	}

	/**This constructor should be used to create new Users and to restore users from the database
	 * @param userId
	 * @param email
	 * @param password
	 * @param displayName
	 * @param rights
	 * @param bidCoins
	 */
	public User(int userId, String email, String password, String displayName,
			UserRights rights, int bidCoins) {
		this(email);
		this.password = password;
		this.displayName = displayName;
		this.rights = rights;
		this.userId = userId;
		this.bidCoins = bidCoins;
		this.myAuctions = new SyncedMap<String, Auction>(userId,
				Queries.selectAllAuctionsOfUser, new AuctionDatabaseCRUD(),
				true, ServiceProvider.getService().getAllAuctions());
		this.myBids = new SyncedMap<String, Bid>(userId,
				Queries.selectAllBidsOfUser, new BidDatabaseCRUD(), false,
				ServiceProvider.getService().getAllBids());
	}

	/**User creates a new Auction
	 * @param auction the auction to create
	 * @return the id of the created Auction
	 * @throws AuctifyException when the database fails to generate an id for the auction
	 */
	public int createAuction(Auction auction) throws AuctifyException {
		auction.setOwner(this);
		auction.setAuctionId(AuctionDatabaseCRUD.generateId());
		myAuctions.put(auction.getIdentifier(), auction);
		return auction.getAuctionId();
	}

	/**Sets the password of the user, and persists the changes to the database by notifying the observers
	 * @param password
	 * @throws AuctifyException 
	 */
	public void setPassword(String password) throws AuctifyException {
		String oldPass = this.password;
		try {
			this.password = password;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.password = oldPass;
			this.changed = false;
			throw e;
		}
	}

	/**Sets the email of the user, and persists the changes to the database by notifying the observers
	 * @param email
	 * @throws AuctifyException 
	 */
	public void setEmail(String email) throws AuctifyException{
		String oldEmail = this.email;
		try {
			this.email = email;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.email = oldEmail;
			this.changed = false;
			throw e;
		}
	}

	/**Sets the person of the user, and persists the changes to the database by notifying the observers
	 * @param person
	 * @throws AuctifyException
	 */
	public void setPerson(Person person)throws AuctifyException{
		Person oldPerson = this.person;
		try {
			this.person = person;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.person = oldPerson;
			this.changed = false;
			throw e;
		}
	}

	/**Sets the address of the user, and persists the changes to the database by notifying the observers
	 * @param address
	 * @throws AuctifyException
	 */
	public void setAddress(Address address) throws AuctifyException {
		Address oldAddress = this.address;
		try {
			this.address = address;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.address = oldAddress;
			this.changed = false;
			throw e;
		}
	}

	/**Sets the displayName of the user, and persists the changes to the database by notifying the observers
	 * @param displayName
	 * @throws AuctifyException
	 */
	public void setDisplayName(String displayName) throws AuctifyException {
		String oldDisplayName = this.displayName;
		try {
			this.displayName = displayName;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.displayName = oldDisplayName;
			this.changed = false;
			throw e;
		}
	}

	/**Sets the rights of the user, and persists the changes to the database by notifying the observers
	 * @param rights
	 * @throws AuctifyException
	 */
	public void setRights(UserRights rights) throws AuctifyException {
		UserRights oldUserRights = this.rights;
		try {
			this.rights = rights;
			this.changed = true;
			notifyObservers();

		} catch (AuctifyException e) {
			this.rights = oldUserRights;
			this.changed = false;
			throw e;
		}
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
	 * @param amount
	 *            Number of BidCoins to increment with
	 * @see #getBidCoins
	 * @see #takeBidCoins
	 */
	public void addBidCoins(int amount) throws AuctifyException {
		int oldBidCoins = this.bidCoins;
		try {
			this.bidCoins += amount;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.bidCoins = oldBidCoins;
			this.changed = false;
			throw e;
		}
	}

	/**
	 * Decrements the users' BidCoins by a certain amount.
	 * 
	 * @param amount
	 *            Number of BidCoins to decrement with
	 * @throws AuctifyException
	 * @see #getBidCoins
	 * @see #addBidCoins
	 */
	public void takeBidCoins(int amount) throws AuctifyException {
		int oldBidCoins = this.bidCoins;
		try {
			this.bidCoins -= amount;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.bidCoins = oldBidCoins;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}

	@Override
	public void register(Observer obs) {
		if (obs == null)
			throw new NullPointerException("Observer is Null");
		if (!observers.contains(obs))
			observers.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() throws AuctifyException {
		List<Observer> observersLocal = null;
		// synchronization is used to make sure any observer registered after
		// message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Observer obs : observersLocal) {
			try {
				obs.updateObserver(this);

			} catch (AuctifyException e) {
				throw new AuctifyException(e.getMessage());
			}
		}

	}

	/**Bid on an auction
	 * @param auctionId the id of the auction to bid on
	 * @param bidAmount the amount to bid
	 * @throws AuctifyException when the user doesn't have enough bidcoins
	 */
	public void bidOnAuction(int auctionId, int bidAmount)
			throws AuctifyException {
		if (this.bidCoins >= bidAmount) {

			Auction auction = ServiceProvider.getService().getAuctionById(
					auctionId);
			Bid bid = new Bid(this, auction, bidAmount);
			
			auction.addBid(bid);
			myBids.put(bid.getIdentifier(), bid);
		} else {
			throw new AuctifyException("Not enough bidcoins available");
		}
	}

	/**removes an auction and all the bids that were placed on it
	 * @param auction the auction to remove
	 */
	public void removeAuction(Auction auction) {
		Map<String,Bid> allBids = ServiceProvider.getService().getAllBids();
		for (Bid bid : auction.getBids().values()) {
			bid.getUser().myAuctions.remove(bid.getIdentifier());
			myBids.remove(bid.getIdentifier());
			ServiceProvider.getService().getAllBids().remove(bid.getIdentifier());
		}
		myAuctions.remove(auction.getIdentifier());
	}
	
	@Override
	public boolean equals(Object obj) {
		User otherUser = (User) obj;
		boolean equals = true;
		equals = equals && email.equals(otherUser.email);
		equals = equals && password.equals(otherUser.password);
		return equals;
	}

	@Override
	public int compareTo(User user) {
		return email.compareTo(user.email);
	}

	@Override
	public String toString() {
		return userId + " " + email + " " + password + " " + displayName + " "
				+ rights + " " + bidCoins;
	}

	@Override
	public Object getUpdate(Observer obs) {
		return (User) this;
	}
	public String getDisplayName() {
		return displayName;
	}
	@Override
	public String getIdentifier() {
		return Integer.toString(userId);
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Person getPerson() {
		return person;
	}
	public Address getAddress() {
		return address;
	}	
	public UserRights getRights() {
		return rights;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SyncedMap<String, Auction> getMyAuctions() {
		return myAuctions;
	}
	public SyncedMap<String, Bid> getMyBids() {
		return myBids;
	}
}