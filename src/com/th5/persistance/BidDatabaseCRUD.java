package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import com.th5.domain.model.Bid;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.util.SortedArrayList;

public class BidDatabaseCRUD implements CRUD_Interface<Bid>{

	public static int generateId() throws AuctifyException {

		int bid_Id;
		Connection connection = DataSourceService.getConnection();

		CallableStatement statement = null;

		try {
			String functionCall = "{? = call seq_bid_pk_bid_id.nextval }";
			statement = connection.prepareCall(functionCall);

			// --- RETURN ----- //
			statement.registerOutParameter(1, Types.NUMERIC);
			statement.executeQuery();

			bid_Id = statement.getInt(1);

			return bid_Id;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new AuctifyException("failed to generate new bid ID");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}
	}

	public int create(Bid bid) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(
					"INSERT INTO BID_BIDS(BID_PK_BID_ID, BID_FK_AUCTION_ID, BID_FK_USER_ID, BID_TIMESTAMP, BID_AMOUNT) VALUES (?,?,?,?,?)");

			statement.setInt(1, bid.getBid_Id());
			statement.setInt(2, bid.getAuction().getAuctionId());
			statement.setInt(3, bid.getUser().getUserId());
			statement.setTimestamp(4, new Timestamp(bid.getTimestamp().getTimeInMillis()));
			statement.setInt(5, bid.getBidAmount());

			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to bid on auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return 0;
	}

	public static List<Bid> getLatestBids() throws AuctifyException {

		Connection connection = DataSourceService.getConnection();
		List<Bid> bidList = new SortedArrayList<>();
		PreparedStatement statement = null;

		try{
			Statement statementx = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet results = statementx.executeQuery("SELECT * FROM (SELECT * FROM BID_BIDS ORDER BY BID_PK_BID_ID DESC) WHERE ROWNUM <7");

			results.afterLast();

			while(results.previous()){
				Bid bid = ResultHandler.restoreBid(results);
				bidList.add(bid);
			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to get latest bids");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return bidList;
	}

	@Override
	public List<Bid> retrieve(String identifier, String query) throws AuctifyException{
		System.out.println("BidDatabaseCRUD.search()::" + query + " " + identifier);
		Connection connection = DataSourceService.getConnection();
		List<Bid> bidList = new SortedArrayList<Bid>();
		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(identifier));

			ResultSet results = statement.executeQuery();

			while(results.next()){
				Bid bid = ResultHandler.restoreBid(results);
				bidList.add(bid);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("Failed search");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return bidList;
	}

	@Override
	public void update(Bid object) throws AuctifyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int auctionId) throws AuctifyException {
		// TODO Auto-generated method stub

	}
}