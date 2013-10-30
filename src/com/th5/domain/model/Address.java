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
		this.postalCode = postalCode;
		this.changed = true;
		notifyObservers();
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) throws AuctifyException {
		this.houseNumber = houseNumber;
		this.changed = true;
		notifyObservers();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) throws AuctifyException {
		this.street = street;
		this.changed = true;
		notifyObservers();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws AuctifyException {
		this.city = city;
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
			obs.updateObserver(this);
		}
		
	}
	@Override
	public Object getUpdate(Observer obs) {
		// TODO Auto-generated method stub
		return (Address) this;
	}

}


