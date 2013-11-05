package com.th5.domain.util;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;

public class EndAuctionEmailer implements Runnable {
	Auction auction;         
	public EndAuctionEmailer(Auction auction) {
		nameOwner = auction.getOwner().getPerson().getFirstName();
	}
	
	String 	nameOwner,
			emailOwner,
			nameWinner,
			emailWinner,
			addressWinner;
			

	public void run() {
		
	}

	protected void sendMail(String email, String message) {


		Properties props = new Properties(); 
		props.put("mail.smtp.host", "gator3182.hostgator.com"); 
		props.put("mail.smtp.port", 465); 
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		try {
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("auctify@smartlapus.com", "Auctify")); 
			msg.setRecipients(Message.RecipientType.TO, email); 
			msg.setSubject("U bent geregistreerd!"); 
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setText("Beste " + ownerName + ", \n\nU bent geregistreerd met gebruikersnaam " + userName + "\n"); 
			Transport.send(msg, "auctify@smartlapus.com", "garbageiscool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
