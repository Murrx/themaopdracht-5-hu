package com.th5.domain.util;

public class IntegerRange extends Range<Integer> {
	public IntegerRange(Integer low, Integer high) {
		super(low, high);
	}
	
	public Boolean withinRange(Integer subject) {
		if(subject.compareTo(getLow()) >= 0 && subject.compareTo(getHigh()) <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
