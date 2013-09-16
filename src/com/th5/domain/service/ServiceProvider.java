package com.th5.domain.service;

public class ServiceProvider {
	private static AuctionServiceInterface auctionService = new AuctionService();
	public static AuctionServiceInterface getService() {
		return auctionService;
	}
}