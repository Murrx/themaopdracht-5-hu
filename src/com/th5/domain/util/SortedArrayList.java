package com.th5.domain.util;

import java.util.ArrayList;
import java.util.Collections;

import com.th5.domain.model.User;

public class SortedArrayList<T extends Comparable<T>> extends ArrayList<T>{
	
	public boolean add(T user) {
        int index = Collections.binarySearch(this, user);
        if (index < 0) index = ~index;
        super.add(index, user);
        return true;
    }

}
