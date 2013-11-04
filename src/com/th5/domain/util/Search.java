package com.th5.domain.util;

import java.util.Collection;
import java.util.Iterator;

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
			if(input != null && search != null) {
				System.out.println(input);
				for(E obj : input) {
					System.out.println(obj);
					if(obj.search(search)) {
						result.add(obj);
					}
				}
				return result;
			} else {
				return null;
			}
	}
}
