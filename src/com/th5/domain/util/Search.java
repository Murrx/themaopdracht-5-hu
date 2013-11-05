package com.th5.domain.util;

import java.util.ArrayList;
import java.util.Collection;

public class Search<E extends Searchable<E>> {
	private Collection<E> result = null;
	private Collection<E> input = null;
	private String search = null;
	
	public Search() {
	}
	
	public Search(String search) {
		this.search = search;
	}
	
	public Search(Collection<E> input) {
		this.input = input;
	}
	
	public Search(Collection<E> input, String search) {
		this.search = search;
		this.input = input;
	}
	
	public void setInput(Collection<E> input) {
		this.input = input;
	}
	
	public void setString(String search) {
		this.search = search;
	}
	
	public Collection<E> getResult() {
		result = new ArrayList<E>();
		if(input != null && search != null) {
			try {
				for(E obj : input) {
					if(obj.search(search)) {
						result.add(obj);
					}
				}
			} catch(Exception e) {
				
			}
			return result;
		} else {
			return null;
		}
	}
}
