/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Product;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;

public class AuctionDatabaseCRUD implements CRUD_Interface<Auction>{

	@Override
	public Auction retrieve(Object actId) throws AuctifyException {
		int auctionId = (Integer)actId;
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		
		PreparedStatement statement = null;
		Auction auction = null;
		Product product = null;

		try{
			statement = connection.prepareStatement(
					"SELECT * FROM auc_auctions WHERE auc_pk_auction_id = ?");
			statement.setInt(1, auctionId);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				
				//auction data
				Calendar aucStartTime =  DateConverter.SQLDateToCalendar(result.getDate("auc_start_time"));
				Calendar aucEndTime =  DateConverter.SQLDateToCalendar(result.getDate("auc_end_time"));
				int aucStatusId = result.getInt("auc_fk_status_id");
				int auctionID = result.getInt("auc_pk_auction_id");
				
				auction = new Auction(auctionID, aucStartTime, aucEndTime, aucStatusId);
				
				//product data
				int productId = result.getInt("prd_pk_product_id");
				String productName = result.getString("prd_name");
				String productDescription = result.getString("prd_description");
				String productPhotoUrl = result.getString("prd_photo_url");
				//category id
				
				product = new Product(productId, productName, productDescription, productPhotoUrl);
				
				auction.setProduct(product);
				
			}

		}catch(SQLException e){
			e.printStackTrace();
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
		if (auction == null) throw new AuctifyException("auction not found");
		return auction;
	}
	

	@Override
	public ArrayList<Auction> search(String search) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Auction> retrieveAll() throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}

	/**Add an auction to the database
	 * @param auction the auction to add
	 * @return the id of the created auction
	 * @throws AuctifyException when the connection fails, or the auction cannot be added
	 */
	@Override
	public int create(Auction auction) throws AuctifyException {
		
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		
		CallableStatement statement = null;
		
		try{
			String functionCall = "{? = call pkg_auction.f_create_auction(?,?,?,?,?,?,?)}";
			statement = connection.prepareCall(functionCall);
			
			// ---  RETURN  ----- //
			statement.registerOutParameter(1, Types.NUMERIC);
			
			// --- AUC_AUCTIONS ---- //
			
			statement.setDate(2, DateConverter.calendarToSQLDate(auction.getStartTime()));
			statement.setDate(3, DateConverter.calendarToSQLDate(auction.getEndTime()));
			statement.setString(4, auction.getCategory().name());
			statement.setInt(5, auction.getUser().getUserId());
			statement.setInt(6, auction.getStartBid());
			
			statement.setString(7, auction.getProduct().getName());
			statement.setString(7, auction.getProduct().getDescription());
			
			statement.executeQuery();
			
			int auctionId = statement.getInt(1);
			return auctionId;
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to add user");
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
	}

	@Override
	public void update(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		
	}

}
