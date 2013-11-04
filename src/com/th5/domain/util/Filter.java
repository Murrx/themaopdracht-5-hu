package com.th5.domain.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Filter<E extends Filterable> {
	private List<Filterable<E>> result = null;
	private List<Filterable<E>> input = null;
	private Map<String, Object> flags = null;
	
	public Filter() {
	}
	
	public Filter(Map<String, Object> flags) {
		this.flags = flags;
	}
	
	public Filter(List<Filterable<E>> input) {
		this.input = input;
	}
	
	public Filter(List<Filterable<E>> input, Map<String, Object> flags) {
		this.flags = flags;
		this.input = input;
	}
	
	public void setInput(List<Filterable<E>> input) {
		this.input = input;
	}
	
	public void setFlags(Map<String, Object> flags) {
		this.flags = flags;
	}
	
	public List<Filterable<E>> getResult() {
		if(input != null && flags != null) {
			Iterator<Filterable<E>> li = result.iterator();
			while(li.hasNext()) {
				Filterable<E> obj = li.next();
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
