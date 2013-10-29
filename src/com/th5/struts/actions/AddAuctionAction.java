package com.th5.struts.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.User;
import com.th5.domain.model.validators.AddAuctionValidator;
import com.th5.domain.model.validators.AttributeError;
import com.th5.struts.awareness.UserAware;

@SuppressWarnings("serial")
public class AddAuctionAction extends ActionSupport implements UserAware, SessionAware, ServletContextAware{
	
	private String 				auction_name,
								auction_description; 
	private Category 			auction_category;
	private int					auction_price;
	private Calendar			auction_end_time;
	private User 				user;
	
	private Map<String, Object>	session;
	private Category[] 			categories = Category.values();
	private File 				fileUpload;
	private String 				fileUploadFileName;
	private ServletContext 		context;
	
	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		
		Auction auction = new Auction(auction_end_time, auction_price, auction_category, auction_name, auction_description);

		int auctionId = user.createAuction(auction);

		FTPClient ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect("ftp.smartlapus.com");
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login("garbage@smartlapus.com", "garbageiscool");
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		InputStream input = new FileInputStream(fileUpload);
		try {
			ftp.storeFile(auctionId + ".jpg", input);
			ftp.logout();
			ftp.disconnect();
		} catch(IOException e) {
			System.out.println("NOOOOOOOO");
		}
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {
		if (!hasFieldErrors()) {
			Auction auction = new Auction(auction_end_time, auction_price, auction_category, auction_name, auction_description);
			AddAuctionValidator aav = new AddAuctionValidator();
			List<AttributeError> auctionAttributeErrorsList = aav.validate(auction);
			if (auctionAttributeErrorsList.size() > 0) {
				for (AttributeError ate : auctionAttributeErrorsList) {
					addFieldError("auction_" + ate.getAttribute(),
							ate.getErrorMessage());
				}
			}
		}
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
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

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;  
		
	}
}
