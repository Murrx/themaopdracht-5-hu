package com.th5.struts.actions.admin;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.th5.domain.model.Bid;
import com.th5.domain.service.AuctionServiceInterface;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.CalendarRange;
import com.th5.domain.util.Filter;

@SuppressWarnings("serial")
public class ViewStatsAction extends ActionSupport {


	private Map<String, Integer> allBids;
	private int numBids;
	
	public String execute() {
		
		AuctionServiceInterface service = ServiceProvider.getService();

		Collection<Bid> bids = service.getAllBids().values();
		Map<String, Object> flags = new HashMap<String, Object>();
		allBids = new TreeMap<String, Integer>();
		CalendarRange dayRange = new CalendarRange();
		
		Calendar now = new GregorianCalendar();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		int currentMonth = now.get(Calendar.MONTH);
		
		while(now.get(Calendar.MONTH) == currentMonth) {
			String day = Integer.toString(now.get(Calendar.DATE));
			Calendar dayLow = now;
			Calendar dayHigh = (Calendar)now.clone();
			dayHigh.add(Calendar.DATE, 1);
			
			dayRange = new CalendarRange(dayLow, dayHigh);
			flags.put("date", dayRange);
			
			int numBids = new Filter<Bid>(bids, flags).getResult().size(); 
			allBids.put(day, numBids);
			now.add(Calendar.DATE, -1);
		}
		
		return ActionSupport.SUCCESS;
	}

	public Map<String, Integer> getAllBids() {
		return allBids;
	}

	public int getNumBids() {
		return numBids;
	}
	
	
	
	

}
