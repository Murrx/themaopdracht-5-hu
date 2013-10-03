/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;

public class Auction implements Comparable<Auction> {

	private long startTime;
	private long endTime;
	private int auctionId;
	
	public Auction(int auctionId) {
		this.auctionId = auctionId;
	}
	
	@Override
	public int compareTo(Auction o) {
		if (auctionId > o.auctionId) {
			return 1;
		}
		else if (auctionId < o.auctionId) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
