package com.th5.domain.other;

import java.util.List;

public interface DatabaseSyncMap<T> {
	public void add(T t) throws AuctifyException;
	public boolean isEmpty();
	public int size();
	public T get(int index);
	public void synchronise();
}
