package com.th5.struts.actions;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.User;
import com.th5.struts.awareness.UserAware;

@SuppressWarnings("serial")
public class AddAuctionAction extends ActionSupport implements UserAware, SessionAware{
	
	private String 		auction_name,
						auction_description; 
	private Category 	auction_category;
	private int			auction_price;
	private Calendar	auction_end_time;
	private User 		user;
	
	private Map	 		session;
	private Category[] 	categories = Category.values();
	private File 		fileUpload;
	private String 		fileUploadFileName;
	
	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		
		Auction auction = new Auction(auction_end_time, auction_price, auction_category, auction_name, auction_description);
		// TODO imageName column in product table, figure out good place to store
		// quick file save test 
//		fileUpload.renameTo(new File("/Users/Mark/Desktop/" + fileUploadFileName));
		// end quick file save test
		user.createAuction(auction);
		
		return ActionSupport.SUCCESS;
	}

	public String getAuction_name() {
		return auction_name;
	}

	public void setAuction_name(String auction_name) {
		this.auction_name = auction_name;
	}

	public String getAuction_description() {
		return auction_description;
	}

	public void setAuction_description(String auction_description) {
		this.auction_description = auction_description;
	}

	public Category getAuction_category() {
		return auction_category;
	}

	public void setAuction_category(Category auction_category) {
		this.auction_category = auction_category;
	}

	public int getAuction_price() {
		return auction_price;
	}

	public void setAuction_price(int auction_price) {
		this.auction_price = auction_price;
	}

	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public Calendar getAuction_end_time() {
		return auction_end_time;
	}
	
	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public void setAuction_end_time(Calendar auction_end_time) {
		this.auction_end_time = auction_end_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileFileUploadName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadName) {
		this.fileUploadFileName = fileUploadName;
	}
}
