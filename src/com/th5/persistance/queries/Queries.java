package com.th5.persistance.queries;

public class Queries {
	public static final String selectAllBidsOfUser = "SELECT * FROM bid_bids WHERE bid_fk_user_id = ?";
	public static final String selectAllAuctionsOfUser = "SELECT * FROM auc_auctions, prd_products WHERE auc_fk_user_id = ? AND auc_pk_auction_id = prd_pk_product_id";
	public static final String selectBidsByAuctionId = "SELECT * FROM BID_BIDS WHERE BID_FK_AUCTION_ID = ?";
	public static final String selectAuctionById = "SELECT * FROM auc_auctions WHERE auc_pk_auction_id = ?";
	public static final String selectAllAuctions = "SELECT * FROM auc_auctions, prd_products WHERE auc_pk_auction_id = prd_pk_product_id";
	public static final String selectUserByEmail = "SELECT * FROM usr_users, prs_persons, adr_addresses WHERE usr_email = ? AND usr_fk_person_id = prs_pk_person_id AND prs_fk_address_id = adr_pk_address_id";	
}
