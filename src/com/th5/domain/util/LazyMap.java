package com.th5.domain.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.th5.domain.model.Identifiable;
import com.th5.domain.model.IdentifiableByEmail;
import com.th5.domain.other.AuctifyException;
import com.th5.persistance.CRUD_Interface;
import com.th5.persistance.queries.Queries;

@SuppressWarnings("serial")
public class LazyMap<K, V extends Identifiable<K> & IdentifiableByEmail<K>> implements DatabaseSynced<V>, Map<K,V> {

	private Map<K,V> idMap;
	private Map<K,V> emailMap;
	
	private CRUD_Interface<V> dbCRUD;
	private boolean inSync = false;
	private boolean modifiesDatabase;

	public LazyMap(boolean modifiesDatabase, CRUD_Interface<V> dbCRUD){
		this.modifiesDatabase = modifiesDatabase;
		idMap = new HashMap<K, V>();
		emailMap = new HashMap<K, V>();
		this.dbCRUD = dbCRUD;
	}
	
	@Override
	public int size() {
		return idMap.size();
	}

	@Override
	public boolean isEmpty() {
		return idMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		V value = get(key);
		return value != null;
	}

	@Override
	public boolean containsValue(Object value) {
		V castValue = (V) value;
		return containsKey(castValue.getIdentifier());
	}

	@Override
	public V get(Object key) {
		V value = null;
		boolean keyIsNumber = false;
		if(isNumber(key)){
			 value = idMap.get(key);
			keyIsNumber = true;
		}else{
			value = emailMap.get(key);
		}
		
		if(value == null){
			String identifier = (String) key;
			try {
				List<V> result = null;
				if(keyIsNumber) result = dbCRUD.retrieve(identifier, Queries.selectUserById);
				else result = dbCRUD.retrieve(identifier,Queries.selectUserByEmail);
				if(!result.isEmpty()){
					idMap.put(result.get(0).getIdentifier(), result.get(0));
					emailMap.put(result.get(0).getIdentifier(), result.get(0));
					value = result.get(0);
				}
			} catch (AuctifyException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public V put(K key, V value) {
		try {
			if(modifiesDatabase)dbCRUD.create(value);
		} catch (AuctifyException e) {
			e.printStackTrace();
		}
		idMap.put(value.getIdentifier(), value);
		return emailMap.put(value.getEmail(), value);
	}

	@Override
	public V remove(Object key) {
		try {
			if(modifiesDatabase)dbCRUD.delete(Integer.parseInt((String)key));
		} catch (NumberFormatException | AuctifyException e) {
			e.printStackTrace();
		}
		emailMap.remove(key);
		return idMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(V value : m.values()){
			put(value.getIdentifier(), value);
		}
	}

	@Override
	public Set<K> keySet() {
		Set<K> keys = new HashSet<K>();
		Collection<V> values = values();
		for(V value : values){
			keys.add(value.getIdentifier());
		}
		return keys;
	}

	@Override
	public Collection<V> values() {
		if(!inSync)synchronize();
		return idMap.values();
	}

	@Override
	public void synchronize() {
		List<V> values = new ArrayList<V>();
		try {
			values = dbCRUD.retrieve(null, Queries.selectAllUsers);
		} catch (AuctifyException e) {
			e.printStackTrace();
		}
		for(V value : values){
			emailMap.put(value.getIdentifier(), value);
			idMap.put(value.getIdentifier(), value);
		}
		inSync = true;
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		if(!inSync)synchronize();
		return idMap.entrySet();
	}
	
	@Override@Deprecated
	public void clear() throws UnsupportedOperationException{throw new UnsupportedOperationException("This method is not supported by this class.");}
	
	private boolean isNumber(Object key){
		boolean isNumber = false;
		try{
			Integer.parseInt((String)key);
			isNumber = true;
		}catch(NumberFormatException e){
			isNumber = false;
		}
		return isNumber;
	}
}
