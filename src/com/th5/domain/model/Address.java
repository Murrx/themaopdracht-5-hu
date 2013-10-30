package com.th5.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.observation.Observable;
import com.th5.domain.observation.Observer;
import com.th5.domain.other.AuctifyException;

public class Address implements Observable {
	
	private String postalCode, houseNumber, street, city;
	private int id;
	
	private List<Observer> observers;
    private final Object MUTEX= new Object();
    private boolean changed;
	
	public Address(String postalCode, String houseNumber, String street, String city){
		this.postalCode = postalCode;
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
	}
	
	public Address(int id, String postalCode, String houseNumber, String street, String city){
		this(postalCode, houseNumber, street, city);
		this.id = id;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) throws AuctifyException {
		String oldPostalCode = this.postalCode;
		try {
			this.postalCode = postalCode;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.postalCode = oldPostalCode;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) throws AuctifyException {
		String oldHouseNumber = this.houseNumber;
		try {
			this.houseNumber = houseNumber;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.houseNumber = oldHouseNumber;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) throws AuctifyException {
		String oldStreet = this.street;
		try{
			this.street = street;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.street = oldStreet;
			this.changed = false;
			throw new AuctifyException(e.getMessage());
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws AuctifyException {
		String oldCity = this.city;
		try	{
			this.city = city;
			this.changed = true;
			notifyObservers();
		} catch (AuctifyException e) {
			this.city = oldCity;
			this.changed=false;
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
	public void notifyObservers() throws AuctifyException {
		// TODO Auto-generated method stub
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<Observer>(this.observers);
			this.changed=false;
		}
	for (Observer obs : observersLocal) {
			try {
				obs.updateObserver(this);
			} catch (AuctifyException e) {
				// TODO Auto-generated catch block
				throw new AuctifyException(e.getMessage());
			}
		}
	}
	@Override
	public Object getUpdate(Observer obs) {
		// TODO Auto-generated method stub
		return (Address) this;
	}
}
