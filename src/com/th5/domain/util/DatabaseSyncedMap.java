package com.th5.domain.util;

import com.th5.domain.other.AuctifyException;

public interface DatabaseSyncedMap<T> {
	public void add(T t) throws AuctifyException;
	public boolean isEmpty();
	public int size();
	public T get(int index);
	public void synchronise();
}
