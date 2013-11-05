package com.th5.domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.service.AuctionService;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.CalendarRange;
import com.th5.domain.util.EndAuctionEmailer;
import com.th5.domain.util.Filterable;
import com.th5.domain.util.IntegerRange;
import com.th5.domain.util.Searchable;
import com.th5.domain.util.SyncedMap;
import com.th5.persistance.AuctionDatabaseCRUD;
import com.th5.persistance.BidDatabaseCRUD;
import com.th5.persistance.queries.Queries;

/**themaopdracht5 - Auctify
 * @author GarbageCollectors 2.0 (Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
 * Contains information about Auction and the methods to perform actions on it.
 */
public class Auction implements Comparable<Auction>, Identifiable<String>, Searchable, Filterable, Observable {

	private SyncedMap<String,Bid> bids;

	private int auctionId;
	private Calendar startTime;
	private Calendar endTime;
	private int startBid;

	private Product product;
	private Category category;
	private Status status;

	private int userId;
	private User owner;

	private List<Observer> observers = new ArrayList<Observer>();
	private final Object MUTEX= new Object();
	private boolean changed;

	@Deprecated
	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}

	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion) {
		this.startTime = Calendar.getInstance();
		this.endTime = endTime;
		this.startBid = startBid;

		this.category = category;
		this.status = Status.ACTIVE;
		this.product = new Product(productName, productDescripion);
	}

	public Auction(Calendar endTime, int startBid, Category category, String productName, String productDescripion, int auctionId, int userId) {
		this(endTime, startBid, category, productName, productDescripion);
		this.auctionId = auctionId;
		this.userId = userId;
		this.bids = new SyncedMap<String,Bid>(auctionId, Queries.selectBidsByAuctionId, new BidDatabaseCRUD(), true);
	}

	public Auction(Calendar startTime, Calendar endTime, int startBid, Category category, int productId, String productName, String productDescripion, int auctionId, int userId, Status status) {
		this(endTime, startBid, category, productName, productDescripion, auctionId, userId);
		this.startTime = startTime;
		this.status = status;
		this.product.setProductId(productId);


	}

	/**Check if the auction has ended. If so the status is set to expired, and the Owner of the auction receives the amount of bidcoins bid on the auction.
	 * Persists this change to the database
	 * and sends an email to the owner and the winner of the action
	 * 
	 * @throws AuctifyException in case the attemp to persist the statuschange fails
	 */
	public void refreshStatus() throws AuctifyException{
		if(status.getRightsValue() >= Status.ACTIVE.getRightsValue()){
			if(Calendar.getInstance().getTimeInMillis() > endTime.getTimeInMillis()){
				try{
					this.register(new AuctionDatabaseCRUD());
					this.setStatus(Status.EXPIRED);
					this.getOwner().addBidCoins(this.getHighestBidAmount());

					new Thread(new EndAuctionEmailer(this)).start();
				} catch(AuctifyException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**Add a bid tho this Auction
	 * @param bid the bid to add.
	 * @throws AuctifyException when the auction has expired, the user trying to bid owns the auction or when the bidding user already is the highest bidder.
	 */
	public synchronized void addBid(Bid bid) throws AuctifyException {

		this.refreshStatus();
		if(this.status == Status.EXPIRED){
			throw new AuctifyException("The auction has expired");
		}
		if (bid.getUser().getUserId() == this.owner.getUserId()) {
			throw new AuctifyException("You are not allowed to place bids on your own auctions.");
		}

		Bid highestBid = getHighestBid();
		if (highestBid != null && highestBid.getUser().getUserId() == bid.getUser().getUserId()) {
			throw new AuctifyException("You are already the highest bidder.");
		}

		if (bid.getBidAmount() == this.calculateNextBidAmount()) {
			if (highestBid != null) {
				highestBid.setBidStatus(BidStatus.LOSING);
				highestBid.refundBidCoins();
			}

			bid.takeBidCoins();
			bid.setBidStatus(BidStatus.WINNING);
			bids.put(bid.getIdentifier(),bid);
		} else {
			throw new AuctifyException("Bid has to be higher than current bid. Please refresh your page and try again! NOOOOOO");
		}

	}

	/**Get the highest bid on this auction
	 * @return the highest Bid object
	 */
	public Bid getHighestBid() {
		Bid highestBid = null;
		int highestBidAmount = 0;
		if (!bids.isEmpty()) {
			for(Bid bid:bids.values()){
				if(bid.getBidAmount() > highestBidAmount){
					highestBid = bid;
					highestBidAmount = bid.getBidAmount();
				}
			}
		}
		return highestBid;
	}

	/**Get the highest bid amount on this Auction
	 * @return the amount of the highest bid.
	 */
	public int getHighestBidAmount() {
		int highestBidAmount = startBid;
		if (!bids.isEmpty()) {
			for(Bid bid:bids.values()){
				if(bid.getBidAmount() > highestBidAmount){
					highestBidAmount = bid.getBidAmount();
				}
			}
		}
		return highestBidAmount;
	}

	public int calculateNextBidAmount() {
		int highestBidAmount = getHighestBidAmount();
		int nextBidAmount = 0;

		// TODO Create an algorithm to
		// increase bid amount.
		nextBidAmount = (int) (highestBidAmount *1.10);
		if( nextBidAmount - highestBidAmount < 1) nextBidAmount++;
		return nextBidAmount;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public int getStartTimeYear() {
		return startTime.get(Calendar.YEAR);
	}

	public int getStartTimeMonth() {
		return startTime.get(Calendar.MONTH);
	}

	public int getStartTimeDate() {
		return startTime.get(Calendar.DATE);
	}

	public int getStartTimeHours() {
		return startTime.get(Calendar.HOUR_OF_DAY);
	}

	public int getStartTimeMinutes() {
		return startTime.get(Calendar.MINUTE);
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public int getPercentage() {
		Long start = startTime.getTimeInMillis();
		Long end = endTime.getTimeInMillis();
		Long now = Calendar.getInstance().getTimeInMillis();
		double procent = (now.doubleValue() - start.doubleValue()) / (end.doubleValue() - start.doubleValue());
		if (procent < 0) {
			procent = 0;
		}
		if (procent > 1) {
			procent = 1;
		}
		return (int) (100 * procent);
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public int getEndTimeYear() {
		return endTime.get(Calendar.YEAR);
	}

	public int getEndTimeMonth() {
		return endTime.get(Calendar.MONTH);
	}

	public int getEndTimeDate() {
		return endTime.get(Calendar.DATE);
	}

	public int getEndTimeHours() {
		return endTime.get(Calendar.HOUR_OF_DAY);
	}

	public int getEndTimeMinutes() {
		return endTime.get(Calendar.MINUTE);
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
		if (bids == null) this.bids = new SyncedMap<String,Bid>(auctionId, Queries.selectBidsByAuctionId, new BidDatabaseCRUD(), true);
	}

	public int getStartBid() {
		return startBid;
	}

	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) throws AuctifyException {
		Status oldStatus = this.status;
		try {
			this.status = status;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.status = oldStatus;
			this.changed = false;
			throw e;
		}

	}

	public Product getProduct() {
		return product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int compareTo(Auction o) {
		if (auctionId > o.auctionId) {
			return 1;
		} else if (auctionId < o.auctionId) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return Integer.toString(auctionId);
	}

	public void setOwner(User owner) {
		this.owner = owner;
		if (this.userId == 0) {
			this.userId = owner.getUserId();
		}
	}

	public User getOwner() {
		if (owner == null) {
			try {
				setOwnerFromUserList();
			} catch (AuctifyException e) {
				e.printStackTrace();
			}
		}
		return owner;
	}

	private void setOwnerFromUserList() throws AuctifyException {
		AuctionService service = (AuctionService) ServiceProvider.getService();
		this.owner = service.getUserById(Integer.toString(userId));
	}

	public SyncedMap<String,Bid> getBids(){
		return bids;
	}

	@Override
	public boolean equals(Object other) {
		boolean equals = true;
		equals = other instanceof Auction;
		if(equals){
			Auction otherAuction = (Auction) other;
			equals = this.auctionId == otherAuction.auctionId;
		}
		return equals;

	}

	@Override
	public String getIdentifier() {
		return Integer.toString(auctionId);
	}

	@Override
	public Boolean search(String search) {
		String productName = product.getName();
		String productDescription = product.getDescription();

		try {
			if(productName.toLowerCase().contains(search.toLowerCase()) || 
					productDescription.toLowerCase().contains(search.toLowerCase())) {
				return true;
			}
		} catch(NullPointerException e) {
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean filter(Map<String, Object> filter) {
		Boolean valid = true;
		if(filter != null) {
			Iterator<Entry<String, Object>> it = filter.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, Object> obj = it.next();
				switch(obj.getKey()) {
				case "owner":
					if(!obj.getValue().equals(new Integer(userId))) {
						valid = false;
					}
					break;
				case "price":
					if(!((IntegerRange)obj.getValue()).withinRange(new Integer(getHighestBidAmount()))) {
						valid = false;
					}
					break;
				case "startDate":
					if(obj.getValue() instanceof CalendarRange) {
						if(!((CalendarRange)obj.getValue()).withinRange(startTime)) {
							valid = false;
						}
					} else {
						if(!startTime.equals(obj.getValue())) {
							valid = false;
						}
					}
					break;
				case "endDate":
					if(obj.getValue() instanceof CalendarRange) {
						if(!((CalendarRange)obj.getValue()).withinRange(endTime)) {
							valid = false;
						}
					} else {
						if(!endTime.equals(obj.getValue())) {
							valid = false;
						}
					}
					break;
				case "category":
					ArrayList<Category> value = new ArrayList<Category>();
					if(obj.getValue() instanceof Category && !(obj.getValue() instanceof List)) {
						value.add((Category)obj.getValue());
					} else {
						value = (ArrayList<Category>)obj.getValue();
					}
					Iterator<Category> catIt = value.iterator();
					Boolean found = false;
					while(catIt.hasNext()) {
						Category category = catIt.next();
						if(this.category.equals(category)) {
							found = true;
							break;
						}
					}
					if(!found) valid = false;
					break;
				case "status":
					ArrayList<Status> statValue = new ArrayList<Status>();
					if(obj.getValue() instanceof Status) {
						statValue.add((Status)obj.getValue());
					} else {
						statValue = (ArrayList<Status>)obj.getValue();
					}
					Iterator<Status> statIt = statValue.iterator();
					Boolean statusFound = false;
					while(statIt.hasNext()) {
						Status status = statIt.next();
						if(status.equals(this.status)) {
							statusFound = true;
						}
					}
					if(!statusFound) valid = false;

					break;
				}
			}
		}
		return valid;
	}

	@Override
	public void register(Observer obs) throws NullPointerException {
		if(obs == null) throw new NullPointerException("Observer is Null");
		if(!observers.contains(obs)) observers.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() throws AuctifyException{
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
		return (Auction) this;
	}
}
