package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.th5.domain.model.Bid;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;
import com.th5.persistance.queries.Queries;

public class BidDatabaseCRUD implements CRUD_Interface<Bid>{

	public static int generateId() throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		CallableStatement statement = null;

		try {
			statement = connection.prepareCall(Queries.generateBidId);
			statement.registerOutParameter(1, Types.NUMERIC);
			statement.executeQuery();

			return statement.getInt(1); 

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("failed to generate new bid ID");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
	}

	public int create(Bid bid) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(Queries.createBid);

			setupCreateStatement(statement, bid);

			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to bid on auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return 0;
	}

	@Override
	public List<Bid> retrieve(String identifier, String query) throws AuctifyException{
		Connection connection = DataSourceService.getConnection();
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(query);
			if(identifier != null)statement.setInt(1, Integer.parseInt(identifier));


			ResultSet results = statement.executeQuery();
			return processResult(results);

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("BidDatabaseCRUD.retrieve()::Failed");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
	}

	@Override
	public void update(Bid object) throws AuctifyException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int auctionId) throws AuctifyException {
		// TODO Auto-generated method stub
	}

	private List<Bid> processResult(ResultSet results) throws AuctifyException, SQLException{
		List<Bid> bidList = new ArrayList<Bid>();

		while(results.next()){
			Bid bid = new Bid(
					results.getInt("BID_PK_BID_ID"), 
					results.getInt("BID_FK_USER_ID"), 
					results.getInt("BID_FK_AUCTION_ID"), 
					DateConverter.SQLDateToCalendar(results.getDate("BID_TIMESTAMP")), 
					results.getInt("BID_AMOUNT"));
			bidList.add(bid);
		}
		return bidList;
	}

	public void setupCreateStatement(PreparedStatement statement, Bid bid) throws SQLException{
		statement.setInt(1, bid.getBid_Id());
		statement.setInt(2, bid.getAuction().getAuctionId());
		statement.setInt(3, bid.getUser().getUserId());
		statement.setTimestamp(4, new Timestamp(bid.getTimestamp().getTimeInMillis()));
		statement.setInt(5, bid.getBidAmount());
	}
}