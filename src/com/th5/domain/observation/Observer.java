package com.th5.domain.observation;

public interface Observer {

	//method to update the observer, used by subject
	public void updateObserver(Object obj);

	//attach with subject to observe
	public void setObservable (Observable obs);
}