package com.th5.domain.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.th5.domain.other.AuctifyException;
import com.th5.persistance.CRUD_Interface;
import com.th5.domain.model.Identifiable;

@SuppressWarnings("serial")
public class SyncedList<E extends Comparable<E> & Identifiable> extends SortedArrayList<E> implements DatabaseSyncedList<E>{

	private int ownerId;
	private String syncQuery;

	private CRUD_Interface<E> dbCRUD;
	private List<E> secondaryList;

	private boolean inSync = false;
	private boolean hasSecondaryList = false;
	private boolean modifiesDatabase;

	/**Use this to construct a normal SynchronisedList
	 * @param ownerId id of the object that contains this list;
	 * @param syncQuery the query used to synchronize to the database
	 * @param dbCRUD the CRUD class used to persist to the database
	 * @param modifiesDatabase true if you want to allow this list to modify the database
	 */
	public SyncedList(int ownerId, String syncQuery, CRUD_Interface<E> dbCRUD, boolean modifiesDatabase){
		this.ownerId = ownerId;
		this.syncQuery = syncQuery;
		this.dbCRUD = dbCRUD;
		this.modifiesDatabase = modifiesDatabase;
	}

	/**Use this to construct a Synchronized list that also keeps track of a secondary list
	 * @param ownerId id of the object that contains this list;
	 * @param syncQuery the query used to synchronize to the database
	 * @param dbCRUD the CRUD class used to persist to the database
	 * @param modifiesDatabase true if you want to allow this list to modify the database
	 * @param secondaryList the secondary list to keep track of	 
	 */
	public SyncedList(int ownerId, String syncQuery, CRUD_Interface<E> dbCRUD, boolean modifiesDatabase, List<E> secondaryList){
		this(ownerId, syncQuery, dbCRUD, modifiesDatabase);
		this.secondaryList = secondaryList;
		this.hasSecondaryList = true;
	}

	@Override
	public int size() {
		if (!inSync)synchronize();
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		if (!inSync)synchronize();
		return super.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (!inSync)synchronize();
		return super.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		if (!inSync)synchronize();
		return super.iterator();
	}

	@Override
	public Object[] toArray() {
		if (!inSync)synchronize();
		return super.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (!inSync)synchronize();
		return super.toArray(a);
	}

	@Override
	public boolean add(E e) {
		try {
			if (modifiesDatabase) dbCRUD.create(e);
			super.add(e);
			if(hasSecondaryList) secondaryList.add(e);
		} catch (AuctifyException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object object) {
		if (!inSync)synchronize();
		@SuppressWarnings("unchecked")
		E identifiable = (E) object;
		int idToRemove = identifiable.getId();
		
		try {
			boolean result0 = false;
			if (modifiesDatabase) dbCRUD.delete(idToRemove);
			if (hasSecondaryList) result0 = secondaryList.remove(object);
			boolean result1 = super.remove(object);
			System.out.println("SyncedList.remove:"+result0+result1);
		} catch (AuctifyException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (!inSync)synchronize();
		return super.containsAll(c);
	}

	@Override
	public E get(int index) {
		if (!inSync)synchronize();
		return super.get(index);
	}

	@Override
	public int indexOf(Object o) {
		if (!inSync)synchronize();
		return super.indexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		if (!inSync)synchronize();
		return listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		if (!inSync)synchronize();
		return listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if (!inSync)synchronize();
		return subList(fromIndex, toIndex);
	}

	@Override
	public void synchronize(){
		inSync = true;
		try {
			List<E> tempList = dbCRUD.search(Integer.toString(ownerId), syncQuery);
			for(E element : tempList){
				super.add(element);
				if(hasSecondaryList)secondaryList.add(element);
			}
		} catch (AuctifyException e) {
//			inSync = false;
			e.printStackTrace();
		}
	}

	@Override@Deprecated
	public int lastIndexOf(Object o) throws UnsupportedOperationException {throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public E set(int index, E element) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public void add(int index, E element) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public E remove(int index) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public boolean addAll(Collection<? extends E> c) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public boolean addAll(int index, Collection<? extends E> c) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public boolean removeAll(Collection<?> c) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public boolean retainAll(Collection<?> c) throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
	@Override@Deprecated
	public void clear() throws UnsupportedOperationException{throw new UnsupportedOperationException("This methot is not implemented. Please contact the support department if you want us to implement this");}
}
