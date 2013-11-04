package com.th5.domain.util;

import java.util.Iterator;
import java.util.List;

public class Search<E extends Searchable> {
	private List<Searchable<E>> result = null;
	private List<Searchable<E>> input = null;
	private String search = null;
	
	public Search() {
	}
	
	public Search(String search) {
		this.search = search;
	}
	
	public Search(List<Searchable<E>> input) {
		this.input = input;
	}
	
	public Search(List<Searchable<E>> input, String search) {
		this.search = search;
		this.input = input;
	}
	
	public void setInput(List<Searchable<E>> input) {
		this.input = input;
	}
	
	public void setString(String search) {
		this.search = search;
	}
	
	public List<Searchable<E>> getResult() {
		if(input != null && search != null) {
			Iterator<Searchable<E>> li = result.iterator();
			while(li.hasNext()) {
				Searchable<E> obj = li.next();
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
