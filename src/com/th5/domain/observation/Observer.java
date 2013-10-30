package com.th5.domain.observation;

import com.th5.domain.other.AuctifyException;

public interface Observer {

	//method to update the observer, used by subject
	public void updateObserver(Object obj) throws AuctifyException;

	//attach with subject to observe
	public void setObservable (Observable obs);
}