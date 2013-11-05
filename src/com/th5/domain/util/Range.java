package com.th5.domain.util;

abstract class Range<E> {
	private E low;
	private E high;
	
	public void setLow(E low) {
		this.low = low;
	}
	
	public void setHigh(E high) {
		this.high = high;
	}
	
	public E getLow() {
		return low;
	}
	
	public E getHigh() {
		return high;
	}
	
	public Range(E low, E high) {
		this.low = low;
		this.high = high;
	}
	
	public Range() {
	}
	
	abstract Boolean withinRange(E subject);
}
