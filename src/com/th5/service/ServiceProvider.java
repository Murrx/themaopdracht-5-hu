package com.th5.service;

public class ServiceProvider {
	private static AuctionServiceInterface auctionService = new AuctionService();
	public static AuctionServiceInterface getBiebService() {
		return auctionService;
	}
}