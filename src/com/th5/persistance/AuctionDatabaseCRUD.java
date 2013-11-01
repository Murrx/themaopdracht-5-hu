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
import com.th5.domain.model.User;
import com.th5.domain.observation.Observable;
import com.th5.domain.other.AuctifyException;
import com.th5.domain.other.DateConverter;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;

public class AuctionDatabaseCRUD implements CRUD_Interface<Auction>{

	public static int generateId() throws AuctifyException {

		int auctionId;
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}

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
			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to retrieve auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		if (auction == null) throw new AuctifyException("auction not found");
		return auction;
	}
	

	@Override
	public ArrayList<Auction> search(String search) throws AuctifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/** Retrieve all auctions the database
	 * @return an ArrayList<Auctions> with all auctions
	 * @throws AuctifyException when the connection fails, or there are no auctions
	 */
	@Override
	public ArrayList<Auction> retrieveAll() throws AuctifyException {
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
		ArrayList<Auction> allAuctions = null;
		PreparedStatement statement = null;
		Auction auction = null;

		try{
			statement = connection.prepareStatement(
					"SELECT * FROM auc_auctions, prd_products WHERE auc_pk_auction_id = prd_pk_product_id");
			ResultSet result = statement.executeQuery();
			allAuctions = new ArrayList<Auction>();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			
			while(result.next()){
				
				//auction data
								
				Calendar aucStartTime =  Calendar.getInstance();
				Calendar aucEndTime =  Calendar.getInstance();
				
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
						
				// auction 
				
				auction = new Auction(aucEndTime, startBid, Category.fromString(categoryString), productName, productDescription, auctionID, userId);
				auction.setStartTime(aucStartTime);
				auction.setStatus(Status.fromInteger(aucStatusId));
				auction.getProduct().setProductId(productId);
				
				allAuctions.add(auction);
				
			}

		}catch(SQLException e){
			//e.printStackTrace();
			throw new AuctifyException("failed to Retrieve All Users");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
		return allAuctions;
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
			return 0;
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new AuctifyException("failed to add auction");
		}finally{
			DataSourceService.closeConnection(connection, statement);
		}
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
		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}
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
	@Override
	public void updateObserver(Object obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setObservable(Observable obs) {
		// TODO Auto-generated method stu		
	}
	
	public void retieveAllBidAuctions(User user) throws AuctifyException {

		Connection connection;
		try {
			connection = DataSourceService.getConnection();
		} catch (SQLException e1) {
			throw new AuctifyException("failed to connect to database");
		}

		PreparedStatement statement = null;
		AuctionServiceInterface service = ServiceProvider.getService();

		try {

			statement = connection
					.prepareStatement("SELECT * FROM bid_bids WHERE bid_fk_user_id = ?");
			statement.setInt(1, user.getUserId());
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Bid bid = new Bid();
				// Bid data

				int bidId = result.getInt("bid_pk_bid_id");
				int auctionId = result.getInt("bid_fk_auction_id");
				int userId = result.getInt("bid_fk_user_id");

				Calendar bidTimeStamp = DateConverter.SQLDateToCalendar(result
						.getDate("bid_timestamp"));
				int bidAmount = result.getInt("bid_amount");
				
				bid.setBid_Id(bidId);
				bid.setBidAmount(bidAmount);
				bid.setTimestamp(bidTimeStamp);
				bid.setUser(service.getUserById(userId));

				Auction auction = service.getAuctionById(auctionId);
				
				bid.setAuction(auction);

				user.getRelevantAuctions().add(auction);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuctifyException("failed to retrieve auction");
		} finally {
			DataSourceService.closeConnection(connection, statement);
		}

	}
}