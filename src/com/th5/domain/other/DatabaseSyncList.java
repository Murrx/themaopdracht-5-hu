package com.th5.domain.other;

import java.util.List;

import com.th5.domain.model.Bid;

public interface DatabaseSyncList<T> {
	public void add(T t) throws AuctifyException;
	public boolean isEmpty();
	public int size();
	public Bid get(int index);
	public List<T> getBids();
	public void synchronise();
}
