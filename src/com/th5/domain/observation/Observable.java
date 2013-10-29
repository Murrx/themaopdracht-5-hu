package com.th5.domain.observation;

public interface Observable {
	
	//methods to register and unregister observers
	public void register(Observer obs);
	public void unregister(Observer obs);

	//method to notify observers of change
	public void notifyObservers();

	//method to get updates from subject
	public Object getUpdate(Observer obs);
}