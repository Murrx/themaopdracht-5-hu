package com.th5.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.th5.domain.model.Bid;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;

public class ResultHandler {

	public static Bid restoreBid(ResultSet results) throws AuctifyException, SQLException{
		Bid bid = new Bid(
				results.getInt("BID_PK_BID_ID"), 
				results.getInt("BID_FK_USER_ID"), 
				results.getInt("BID_FK_AUCTION_ID"), 
				DateConverter.SQLDateToCalendar(results.getDate("BID_TIMESTAMP")), 
				results.getInt("BID_AMOUNT"));
		return bid;
	}

}
