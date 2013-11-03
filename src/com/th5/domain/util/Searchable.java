package com.th5.domain.model.utils;

import java.util.List;
import java.util.Map;

public interface Searchable<E> {
	public List<E> search(Map<String, String> parameters); 
}
