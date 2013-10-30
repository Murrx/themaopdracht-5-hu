package com.th5.domain.observation;

import com.th5.domain.other.AuctifyException;

public interface Observable {
	
	//methods to register and unregister observers
	public void register(Observer obs);
	public void unregister(Observer obs);

	//method to notify observers of change
	public void notifyObservers() throws AuctifyException;

	//method to get updates from subject
	public Object getUpdate(Observer obs);
}