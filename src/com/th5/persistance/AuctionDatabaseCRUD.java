/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 3 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Person;
import com.th5.domain.model.Product;
import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.other.AuctifyException;

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
		//Product product = null;

		try{
			statement = connection.prepareStatement(
					"SELECT * FROM auc_auctions WHERE auc_pk_auction_id = ?");
			statement.setInt(1, auctionId);
			ResultSet result = statement.executeQuery();

			while(result.next()){
				
				//auction data
				long aucStartTime = result.getLong("auc_start_time");
				long aucEndTime = result.getLong("auc_end_time");
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
				
				
				
				//user.setPerson(person);
				//user.setAddress(address);
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

	@Override
	public int create(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub
		return (0);
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
