package com.th5.persistance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.Status;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;

public class AuctionDatabaseCRUD implements CRUD_Interface<Auction>{

	public static int generateId() throws AuctifyException {

		int auctionId;
		Connection connection = DataSourceService.getConnection();
		CallableStatement statement = null;

		try {
			String functionCall = "{? = call seq_auc_pk_auction_id.nextval }";
			statement = connection.prepareCall(functionCall);

			// --- RETURN ----- //
			statement.registerOutParameter(1, Types.NUMERIC);
			statement.executeQuery();

			auctionId = statement.getInt(1);

			return auctionId;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("failed to generate new Auction ID");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}

	}

	@Override
	public List<Auction> retrieve(String identifier, String query) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		List<Auction> auctionList = new ArrayList<Auction>();
		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(query);
			if (identifier != null) statement.setInt(1, Integer.parseInt(identifier));
			ResultSet result = statement.executeQuery();
			
			return processResult(result);
		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to retrieve auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
	}

	/**Add an auction to the database
	 * @param auction the auction to add
	 * @return the id of the created auction
	 * @throws AuctifyException when the connection fails, or the auction cannot be added
	 */
	@Override
	public int create(Auction auction) throws AuctifyException {

		Connection connection = DataSourceService.getConnection();
		CallableStatement statement = null;

		try{
			String functionCall = "{call pkg_auction.p_create_auction(?,?,?,?,?,?,?,?)}";
			statement = connection.prepareCall(functionCall);

			// --- AUC_AUCTIONS ---- //
			statement.setInt(1, auction.getAuctionId());
			statement.setTimestamp(2, new java.sql.Timestamp(auction.getStartTime().getTimeInMillis()));
			statement.setTimestamp(3, new java.sql.Timestamp(auction.getEndTime().getTimeInMillis()));
			//statement.setDate(3, DateConverter.calendarToSQLDate(auction.getEndTime()));
			statement.setString(4, auction.getCategory().name());
			statement.setInt(5, auction.getOwner().getUserId());
			statement.setInt(6, auction.getStartBid());

			statement.setString(7, auction.getProduct().getName());
			statement.setString(8, auction.getProduct().getDescription());

			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to add auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return 0;
	}

	@Override
	public void update(Auction object) throws AuctifyException {
		// TODO Auto-generated method stub

	}

	/**Delete user from database. Use with care.
	 * @see com.th5.persistance.CRUD_Interface#delete(java.lang.Object)
	 */
	@Override
	public void delete(int auctionId) throws AuctifyException {
		Connection connection = DataSourceService.getConnection();
		PreparedStatement statement = null;
		try{
			statement = connection.prepareCall("{call pkg_auction.pr_delete_auction(?)}");		
			statement.setInt(1, auctionId);
			statement.executeQuery();

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to delete auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
	}
	
	private List<Auction> processResult(ResultSet result) throws AuctifyException, SQLException{
		List<Auction> auctionList = new ArrayList<Auction>();
		
		while(result.next()){
			Auction auction = null;
			
			//auction data
			Calendar aucStartTime = Calendar.getInstance();
			Calendar aucEndTime = Calendar.getInstance();
			aucStartTime.setTimeInMillis(result.getTimestamp("auc_start_time").getTime());
			aucEndTime.setTimeInMillis(result.getTimestamp("auc_end_time").getTime());

			int aucStatusId = result.getInt("auc_fk_status_id");
			int auctionID = result.getInt("auc_pk_auction_id");

			int startBid = result.getInt("auc_start_bid");
			String categoryString = result.getString("auc_fk_category");

			int userId = result.getInt("auc_fk_user_id");

			//product data
			int productId = result.getInt("prd_pk_product_id");
			String productName = result.getString("prd_name");
			String productDescription = result.getString("prd_description");
			// auction

			auction = new Auction(aucEndTime, startBid, Category.fromString(categoryString), productName, productDescription, auctionID, userId);

			auction.setStartTime(aucStartTime);
			auction.setStatus(Status.fromInteger(aucStatusId));
			auction.getProduct().setProductId(productId);
			
			auctionList.add(auction);
		}
		return auctionList;
	}
}