package com.th5.domain.util;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class SortedArrayList<T extends Comparable<T>> extends ArrayList<T>{
	
	public boolean add(T type) {
        int index = Collections.binarySearch(this, type);
        if (index < 0) index = ~index;
        super.add(index, type);
        return true;
    }
}
