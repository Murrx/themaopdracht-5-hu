package com.th5.domain.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Filter<E extends Filterable> {
	private Collection<E> result = null;
	private Collection<E> input = null;
	private HashMap<String, Object> flags = null;
	
	public Filter() {
	}
	
	public Filter(HashMap<String, Object> flags) {
		this.flags = flags;
	}
	
	public Filter(Collection<E> input) {
		this.input = input;
	}
	
	public Filter(Collection<E> input, HashMap<String, Object> flags) {
		this.flags = flags;
		this.input = input;
	}
	
	public void setInput(Collection<E> input) {
		this.input = input;
	}
	
	public void setFlags(HashMap<String, Object> flags) {
		this.flags = flags;
	}
	
	public Collection<E> getResult() {
		result = new ArrayList<E>();
		if(input != null && flags != null) {
			Iterator<E> li = input.iterator();
			while(li.hasNext()) {
				E obj = li.next();
				if(obj.filter(flags)) {
					result.add(obj);
				}
			}
			return result;
		} else {
			return null;
		}
	}
}
