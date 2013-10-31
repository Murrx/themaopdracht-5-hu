package com.th5.domain.other;

import com.th5.domain.model.Auction;

public interface DatabaseSyncList<T> {
	public void add(T t) throws AuctifyException;
	public boolean isEmpty();
	public int size();
	public T get(int index);
	public void synchronise();
	int indexOf(T t);
}
