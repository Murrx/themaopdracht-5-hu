package com.th5.domain.util;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.th5.domain.model.Address;
import com.th5.domain.model.Auction;
import com.th5.domain.model.User;

public class EndAuctionEmailer implements Runnable {
	
	private	String 		auctionName,
						nameOwner,
						emailOwner,
	
						nameWinner,
						emailWinner;
	private	Address 	addressWinner;
	private User 		winner;
	
	private final String subjectWinner = "you have won an auction";
	private final String subjectOwner = "Your product has been sold";
	private final String subjectProductNotSold = "Your auction ended";
	
	private String 		messageWinner			= 	"Hi " + nameWinner + "\n\n" +
													"You have won the auction \"" + auctionName +"\"\n" +
													"Your product will be send to you within 7 days.\n\n" +
													"Kind regards, Auctify";
	
	private String 		messageOwner			= 	"Hi " + nameOwner + "\n\n" +
													"Your product \"" + auctionName +"\" has been sold.\n" +
													"Please send the product to the folowing address within 7 days:\n\n" +
													addressWinner + "\n\n" +
													"Kind regards, Auctify";
	
	private String 		MessageProductNotSold	= 	"Hi " + nameOwner + "\n\n" +
													"Your product \"" + auctionName +"\" was not sold...\n" +
													"Feel free to give it another try.\n\n" +
													"Kind regards, Auctify";
	
	
	public EndAuctionEmailer(Auction auction) {
		nameOwner = auction.getOwner().getPerson().getFirstName();
		emailOwner = auction.getOwner().getEmail();
		auctionName = auction.getProduct().getName();
		
		try{
			winner = auction.getHighestBid().getUser();
		}catch(NullPointerException e){}
		
		if(winner != null){
			nameWinner = winner.getPerson().getFirstName();
			emailWinner = winner.getEmail();
			addressWinner = winner.getAddress();
		}
	}
	
	public EndAuctionEmailer(){
		winner = new User(1);
		nameOwner = "*ownerName*";
		emailOwner = "altenarobin@gmail.com";
		
		nameWinner = "*winnerName*";
		emailWinner = "altenarobin@gmail.com";
		addressWinner = new Address("3766MC", "74", "Insingerstraat 74", "Soest");
		auctionName = "*auctionName*";
	}
			
	
	
	public void run() {
		if(winner != null){
			sendMail(emailWinner, messageWinner, subjectWinner);
			sendMail(emailOwner, messageOwner, subjectOwner);
		}else{
			sendMail(emailOwner, MessageProductNotSold, subjectProductNotSold);
		}
	}

	private void sendMail(String email, String message, String subject) {
		Properties props = new Properties(); 
		props.put("mail.smtp.host", "gator3182.hostgator.com"); 
		props.put("mail.smtp.port", 465); 
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		try {
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("auctify@smartlapus.com", "Auctify")); 
			msg.setRecipients(Message.RecipientType.TO, email); 
			msg.setSubject(subject); 
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setText(message); 
			Transport.send(msg, "auctify@smartlapus.com", "garbageiscool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[]args){
		EndAuctionEmailer end = new EndAuctionEmailer();
		end.run();
	}
}
