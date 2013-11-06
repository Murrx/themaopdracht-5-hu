package com.th5.struts.actions.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Bid;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.CalendarRange;
import com.th5.domain.util.Filter;

@SuppressWarnings("serial")
public class ViewStatsAction extends ActionSupport {


	private Map<Integer, ArrayList<Integer>> data;
	private Auction popularAuction;
	
	public String execute() {
		
		AuctionServiceInterface service = ServiceProvider.getService();

		Collection<Bid> bids = service.getAllBids().values();
		Collection<Auction> auctions = service.getAllAuctions().values();
		
		data = new TreeMap<Integer, ArrayList<Integer>>();

		Map<String, Object> bidFlags = new HashMap<String, Object>();
		Map<String, Object> auctionStartFlags = new HashMap<String, Object>();
		Map<String, Object> auctionEndFlags = new HashMap<String, Object>();
		CalendarRange dayRange = new CalendarRange();
		
		Calendar now = new GregorianCalendar();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		
		int currentMonth = now.get(Calendar.MONTH);
		
		while(now.get(Calendar.MONTH) == currentMonth) {
			Integer day = now.get(Calendar.DATE);
			Calendar dayLow = now;
			Calendar dayHigh = (Calendar)now.clone();
			dayHigh.add(Calendar.DATE, 1);
			
			dayRange = new CalendarRange(dayLow, dayHigh);
			
			bidFlags.put("date", dayRange);
			auctionStartFlags.put("startDate", dayRange);
			auctionEndFlags.put("endDate", dayRange);
			
			Collection<Bid> filteredBids = new Filter<Bid>(bids, bidFlags).getResult();

			class MaxComparator implements Comparator<Bid> {

				@Override
				public int compare(Bid o1, Bid o2) {
					Integer o1Bid = o1.getBidAmount();
					Integer o2Bid = o2.getBidAmount();
					
					return o1Bid.compareTo(o2Bid);
				}
				
			}
			
			int numBids = filteredBids.size();
			int maxBid = 0;
			try {
				maxBid = (Collections.max(filteredBids, new MaxComparator())).getBidAmount();
			} catch(Exception e) {
			}
			int numCreations = new Filter<Auction>(auctions, auctionStartFlags).getResult().size();
			int numEndings = new Filter<Auction>(auctions, auctionEndFlags).getResult().size();
			
			ArrayList<Integer> dayData = new ArrayList<Integer>();
			dayData.add(numBids);
			dayData.add(numCreations);
			dayData.add(numEndings);
			dayData.add(maxBid);
			
			data.put(day, dayData);
			now.add(Calendar.DATE, -1);
		}
		
		class PopularComparator implements Comparator<Auction> {

			@Override
			public int compare(Auction o1, Auction o2) {
				Integer o1Bid = o1.getBids().size();
				Integer o2Bid = o2.getBids().size();
				
				return o1Bid.compareTo(o2Bid);
			}
			
		}
		
		setPopularAuction((Collections.max(auctions, new PopularComparator())));
		
		now = new GregorianCalendar();
		ArrayList<Integer> nullData = new ArrayList<Integer>();
		nullData.add(0);
		nullData.add(0);
		nullData.add(0);
		nullData.add(0);
		
		while(now.get(Calendar.MONTH) == currentMonth) {
			Integer day = now.get(Calendar.DATE);
			
			data.put(day, nullData);
			now.add(Calendar.DATE, 1);
		}
		System.out.println(data);
		return ActionSupport.SUCCESS;
	}

	public Map<Integer, ArrayList<Integer>> getData() {
		return data;
	}

	public Auction getPopularAuction() {
		return popularAuction;
	}

	public void setPopularAuction(Auction popularAuction) {
		this.popularAuction = popularAuction;
	}
}
