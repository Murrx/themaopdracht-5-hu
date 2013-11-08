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
						emailWinner,
						lastNameWinner;
	private	Address 	addressWinner;
	private User 		winner;
	
	private final String subjectWinner = "you have won an auction";
	private final String subjectOwner = "Your product has been sold";
	private final String subjectProductNotSold = "Your auction ended";
	
	private String 		messageWinner;
	
	private String 		messageOwner;
	
	private String 		MessageProductNotSold;
	
	
	public EndAuctionEmailer(Auction auction) {
		nameOwner = auction.getOwner().getPerson().getFirstName();
		emailOwner = auction.getOwner().getEmail();
		auctionName = auction.getProduct().getName();
		
		try{
			winner = auction.getHighestBid().getUser();
		}catch(NullPointerException e){}
		
		if(winner != null){
			nameWinner = winner.getPerson().getFirstName();
			lastNameWinner = winner.getPerson().getLastName();
			emailWinner = winner.getEmail();
			addressWinner = winner.getAddress();
		}
		setupMessages();
	}
	
	private void setupMessages(){
		messageWinner = 		"Hi " + nameWinner + "\n\n" +
				"You have won the auction \"" + auctionName +"\"\n" +
				"Your product will be send to you within 7 days.\n\n" +
				"Kind regards, Auctify";

		messageOwner = 			"Hi " + nameOwner + "\n\n" +
				"Your product \"" + auctionName +"\" has been sold.\n" +
				"Please send the product to the folowing address within 7 days:\n\n" +
				nameWinner + " " + lastNameWinner + "\n" +
				addressWinner + "\n\n" +
				"Kind regards, Auctify";

		MessageProductNotSold= 	"Hi " + nameOwner + "\n\n" +
				"Your product \"" + auctionName +"\" was not sold...\n" +
				"Feel free to give it another try.\n\n" +
				"Kind regards, Auctify";
	}
			
	
	
	public void run() {
		
		if(winner != null){
			System.out.println("EndAuctionEmailer.run()::Sending mail to " + emailWinner + " and " + emailOwner);
			sendMail(emailWinner, messageWinner, subjectWinner);
			sendMail(emailOwner, messageOwner, subjectOwner);
		}else{
			System.out.println("EndAuctionEmailer.run()::Sending mail to " +  emailOwner);
			sendMail(emailOwner, MessageProductNotSold, subjectProductNotSold);
		}
	}

	private void sendMail(String email, String message, String subject) {
		Properties props = new Properties(); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
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
			Transport.send(msg, "markvlpublic@gmail.com", "kijktUMaar1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
