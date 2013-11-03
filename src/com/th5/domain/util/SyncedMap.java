package com.th5.domain.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.th5.domain.model.Identifiable;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.CRUD_Interface;


@SuppressWarnings({ "serial"})
public class SyncedMap<K, V extends Comparable<V> & Identifiable<K>> extends HashMap<K, V> implements DatabaseSynced<V>, Map<K,V>{

	private int ownerId;
	private String syncQuery;

	private CRUD_Interface<V> dbCRUD;
	private Map<K,V> secondaryMap;

	private boolean inSync = false;
	private boolean hasSecondaryMap = false;
	private boolean modifiesDatabase;

	/**Use this to construct a normal SyncedMap
	 * @param ownerId id of the object that contains this Map;
	 * @param syncQuery the query used to synchronize to the database
	 * @param dbCRUD the CRUD class used to persist to the database
	 * @param modifiesDatabase true if you want to allow this map to modify the database
	 */
	public SyncedMap(int ownerId, String syncQuery, CRUD_Interface<V> dbCRUD, boolean modifiesDatabase){
		this.ownerId = ownerId;
		this.syncQuery = syncQuery;
		this.dbCRUD = dbCRUD;
		this.modifiesDatabase = modifiesDatabase;
	}

	/**Use this to construct a SyncedMap that also keeps track of a secondary map
	 * @param ownerId id of the object that contains this map
	 * @param syncQuery the query used to synchronize to the database
	 * @param dbCRUD the CRUD class used to persist to the database
	 * @param modifiesDatabase true if you want to allow this map to modify the database
	 * @param secondaryMap the secondary list to keep track of	 
	 */
	public SyncedMap(int ownerId, String syncQuery, CRUD_Interface<V> dbCRUD, boolean modifiesDatabase, Map<K,V> secondaryMap){
		this(ownerId, syncQuery, dbCRUD, modifiesDatabase);
		this.secondaryMap = secondaryMap;
		this.hasSecondaryMap = true;
	}
	
	@Override
	public int size() {
		if(!inSync)synchronize();
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		if(!inSync)synchronize();
		return super.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		if(!inSync)synchronize();
		return super.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		if(!inSync)synchronize();
		return super.containsValue(value);
	}

	@Override
	public V get(Object key) {
		if(!inSync)synchronize();
		return super.get(key);
	}
	
	@Override
	public V remove(Object key) {
		if (!inSync)synchronize();
		V removedObject = null;
		try {
			if (modifiesDatabase) dbCRUD.delete((int)key);
			if (hasSecondaryMap) secondaryMap.remove(key);
			removedObject = super.remove(key);
		} catch (AuctifyException e) {
			e.printStackTrace();
		}
		return removedObject;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void putAll(Map m) {
		//Todo:This method needs some love
		if(!inSync)synchronize();
		
	}
	
	@Override
	public V put(K key, V value) {
		if (!inSync)synchronize();
		try {
			if (modifiesDatabase) {
				dbCRUD.create(value);
			}
			V object = super.put(key,value);
			if(hasSecondaryMap) {
				secondaryMap.put(key,value);
			}
			return object;
		} catch (AuctifyException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	@Override
	public Set<K> keySet() {
		if(!inSync)synchronize();
		return super.keySet();
	}

	@Override
	public Collection<V> values() {
		if(!inSync)synchronize();
		return super.values();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set entrySet() {
		if(!inSync)synchronize();
		return super.entrySet();
	}

	@Override
	public void synchronize() {
		inSync = true;
		try {
			List<V> tempList = dbCRUD.search(Integer.toString(ownerId), syncQuery);
			for(V element : tempList){
				super.put(element.getIdentifier(), element);
				if(hasSecondaryMap)secondaryMap.put(element.getIdentifier(), element);
			}
		} catch (AuctifyException e) {
			inSync = false;
			e.printStackTrace();
		}
	}
	

	@Override@Deprecated
	public void clear() throws UnsupportedOperationException{throw new UnsupportedOperationException("This method is not supported by this class.");}
}
