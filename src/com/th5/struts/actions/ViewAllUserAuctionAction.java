package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.model.User;
import com.th5.struts.awareness.UserAware;

public class ViewAllUserAuctionAction extends ActionSupport implements UserAware {
	
	private List<Auction> allAuctions;
	private User user;
	private List<Bid> allBids = new ArrayList<Bid>();  

	@Override
	public String execute() throws Exception {
		try {
			System.out.println("user: " + user.getDisplayName());
			System.out.println("vieuw all user auctions");
			allAuctions = user.getUsersAuction().getAuctions();
			System.out.println("size: all auctions " + allAuctions.size());
			
			if (user.getBidAuctions() != null) {
				System.out.println("user.getrelavantauctions != null!");
				System.out.println("relevant auctions size: " + user.getBidAuctions().getBidAuctions().size());
			for (Auction auc : user.getBidAuctions().getBidAuctions()) {
				System.out.println("auc : " + auc.getAuctionId());
				for (Bid bia : auc.getBidList().getBids()) {
					System.out.println("bia : = " + bia.getBid_Id() + ", " + bia.getBidAmount());
				}
				for (Bid bid : auc.getBidList().getBids()) {
					System.out.println("bid = " + bid.getBid_Id());
					allBids.add(bid);
				}
			}
			}
			System.out.println("allbids size: " + allBids.size());
			System.out.println(allAuctions);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error: " + e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public List<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public List<Bid> getAllBids() {
		return this.allBids;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
}
