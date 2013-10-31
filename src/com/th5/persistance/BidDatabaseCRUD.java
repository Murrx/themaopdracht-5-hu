package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.Category;
import com.th5.domain.model.Status;
import com.th5.domain.observation.Observable;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;

public class BidDatabaseCRUD implements CRUD_Interface<Bid> {

	private int bid_Id;

	public int generateId() throws AuctifyException {

		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}

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
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int create(Bid bid) throws AuctifyException {
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(
					"INSERT INTO BID_BIDS(BID_PK_BID_ID, BID_FK_AUCTION_ID, BID_FK_USER_ID, BID_TIMESTAMP, BID_AMOUNT) VALUES (?,?,?,?,?)");
			
			statement.setInt(1, bid.getBid_Id());
			statement.setInt(2, bid.getAuction().getAuctionId());
			statement.setInt(3, bid.getUser().getUserId());
			statement.setDate(4, DateConverter.calendarToSQLDate(bid.getTimestamp()));
			statement.setInt(5, bid.getBidAmount());
			
			statement.executeQuery();
			
		}catch(SQLException e){
			throw new AuctifyException("failed to bid on auction");
		}finally{
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public void updateObserver(Object obj) throws AuctifyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setObservable(Observable obs) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bid retrieve(Object identifier) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bid> search(String search) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bid> retrieveAll() throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Bid object) throws AuctifyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bid object) throws AuctifyException {
		// TODO Auto-generated method stub

	}

}
