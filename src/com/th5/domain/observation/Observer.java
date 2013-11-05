package com.th5.domain.observation;

import com.th5.domain.other.AuctifyException;

/**
 * themaopdracht5 - Auctify<br>
 * This interface contains the methods for the Observer. An observer is a class that observes
 * an observable. The observer is responsible for handling changes in the observable object.
 * Whenever a change is detected, the method updateObserver() is called.
 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
 * @see Observable 
 */
public interface Observer {

	/**
	 * themaopdracht5 - Auctify<br>
	 * This method is responsible for updating the object that has been changed.
	 * @param obj The object that has changed
	 * @throws AuctifyException should be thrown when the method fails to update the observer
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 */
	public void updateObserver(Object obj) throws AuctifyException;

	/**
	 * themaopdracht5 - Auctify<br>
	 * This method sets the observable object that should be observed by the observer.
	 * @param obs The observable object that has to be observed
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 */
	public void setObservable (Observable obs);
}