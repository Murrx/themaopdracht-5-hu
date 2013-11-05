package com.th5.domain.observation;

import com.th5.domain.other.AuctifyException;

/**
 * themaopdracht5 - Auctify<br>
 * This interface contains the methods for the Observable. An observable is a class that is observed by
 * an observer. The observable notifies the observer whenever it changes.
 * When a change is detected, the method notifyObservers() is called.
 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
 * @see Observer 
 */
public interface Observable {
	
	/**
	 * themaopdracht5 - Auctify<br>
	 * This method registers a new observer for the observable. The observer will be notified if the
	 * notifiedObservers() method is called.
	 * @param obs The new observer to register
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 * @see #unregister
	 */
	public void register(Observer obs);
	
	/**
	 * themaopdracht5 - Auctify<br>
	 * This method removes an observer from the observable. The observer will not be notified anymore if the
	 * notifiedObservers() method is called.
	 * @param obs The observer to remove
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 * @see #register
	 */
	public void unregister(Observer obs);

	/**
	 * themaopdracht5 - Auctify<br>
	 * This method will be called whenever the observers need to be notified of a change. All the observers
	 * that are registered with the register() method are notified.
	 * @throws AuctifyException should be thrown when the method fails to notify the observers.
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 * @see #register
	 */
	public void notifyObservers() throws AuctifyException;

	/**
	 * themaopdracht5 - Auctify<br>
	 * Gets the updated observable object from a specific observer.
	 * @param obs The observer to get the update from
	 * @author <b>GarbageCollectors 2.0 </b>(Dimiter Geelen, Mark Van Lagen, Martin Bakker, Joris Rijkes and Robin Altena)
	 */
	public Object getUpdate(Observer obs);
}