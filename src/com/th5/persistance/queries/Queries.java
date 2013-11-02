package com.th5.persistance.queries;

public class Queries {
	public static final String userGetAllBids = "SELECT * FROM bid_bids WHERE bid_fk_user_id = ?";
	public static final String auctionGetAllBids = "SELECT * FROM BID_BIDS WHERE BID_FK_AUCTION_ID = ?";
}
