/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 5 nov. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;


public enum BidStatus {
	WINNING(0), LOSING(1), LOST(2), WON(3);
	
	private int statusValue;
	
	private BidStatus(int statusValue) {
		this.statusValue = statusValue;
	}
	
	public static BidStatus fromInteger(int x) {
		switch (x) {
		case 0:
			
			return WINNING;
		case 1:
		return LOSING;
		case 2:
			return LOST;
		case 3:
			return WON;
		}
		return null;
	}
	
	public int getStatusValue() {
		return statusValue;
	}
}