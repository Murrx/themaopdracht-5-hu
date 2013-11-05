package com.th5.struts.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.service.ServiceProvider;
import com.th5.domain.util.CalendarRange;
import com.th5.domain.util.Filter;
import com.th5.domain.util.IntegerRange;
import com.th5.domain.util.Search;

@Conversion()
@SuppressWarnings("serial")
public class SearchAuctionsAction extends ActionSupport {

	private Collection<Auction> allAuctions;
	private Category[] 			categories = Category.values();
	private String search;
	
	private int priceRangeLow;
	private int priceRangeHigh;
	private Calendar startDateLow;
	private Calendar startDateHigh;
	private Calendar endDateLow;
	private Calendar endDateHigh;
	
	private ArrayList<String> selectedCategories;
	
	private Map<String, Object> flags;

	@Override
	public String execute() {
		try {
			if(search == null) search = "";
			Collection<Auction> auctions = ServiceProvider.getService().getAllAuctions().values();
			Search<Auction> searchResult = new Search<Auction>(auctions, search);
			Collection<Auction> searchAuctions = searchResult.getResult();
			Filter<Auction> filterResult = new Filter<Auction>(searchAuctions);
			//flags.put('status', )
			
			
			if(flags != null && !flags.isEmpty()) {
				filterResult.setFlags(flags);
				allAuctions = filterResult.getResult();
			} else {
				allAuctions = searchResult.getResult();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
 		
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {
		flags = new TreeMap<String, Object>();
		if(startDateLow != null && startDateHigh != null) {
			CalendarRange startDateRange = new CalendarRange(startDateLow, startDateHigh);
			flags.put("startDate", startDateRange);
		}
		if(endDateLow != null && endDateHigh != null) { 
			CalendarRange endDateRange = new CalendarRange(endDateLow, endDateHigh);
			flags.put("endDate", endDateRange);
		}
		if(priceRangeHigh != 0) {
			IntegerRange priceRange = new IntegerRange(new Integer(priceRangeLow), new Integer(priceRangeHigh));
			flags.put("price", priceRange);
		}
		if(selectedCategories != null) {
			ArrayList<Category> categories = new ArrayList<Category>();
			Iterator<String> it = selectedCategories.iterator();
			while(it.hasNext()) {
				String category = it.next();
				categories.add(Category.fromString(category));
			}
			if(!categories.isEmpty()) flags.put("category", categories);
		}
		
	}
	
	public Collection<Auction> getAllAuctions() {
		return this.allAuctions;
	}
	
	public void setAllAuctions(ArrayList<Auction> al) {
		this.allAuctions = al;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getSearch() {
		return search;
	}
	
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public int getPriceRangeLow() {
		return priceRangeLow;
	}

	public void setPriceRangeLow(int priceLow) {
		this.priceRangeLow = priceLow;
	}
	
	public int getPriceRangeHigh() {
		return priceRangeHigh;
	}

	public void setPriceRangeHigh(int priceHigh) {
		this.priceRangeHigh = priceHigh;
	}	
	
	public Date getStartDateLowDate() {
		if(startDateLow != null) {
			return startDateLow.getTime();
		} else {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.add(Calendar.MONTH, -1);
			return calendar.getTime();
		}
	}

	public Date getStartDateHighDate() {
		if(startDateHigh != null) {
			return startDateHigh.getTime();
		} else {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			return calendar.getTime();
		}
	}

	public Date getEndDateLowDate() {
		if(endDateLow != null) {
			return endDateLow.getTime();
		} else {
			GregorianCalendar calendar = new GregorianCalendar();
			return calendar.getTime();
		}
	}

	public Date getEndDateHighDate() {
		if(endDateHigh != null) {
			return endDateHigh.getTime();
		} else {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.add(Calendar.YEAR, 1);
			return calendar.getTime();
		}
	}


	public Calendar getStartDateLow() {
		return startDateLow;
	}

	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public void setStartDateLow(Calendar startDateLow) {
		this.startDateLow = startDateLow;
	}

	public Calendar getStartDateHigh() {
		return startDateHigh;
	}

	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public void setStartDateHigh(Calendar startDateHigh) {
		this.startDateHigh = startDateHigh;
	}

	public Calendar getEndDateLow() {
		return endDateLow;
	}

	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public void setEndDateLow(Calendar endDateLow) {
		this.endDateLow = endDateLow;
	}

	public Calendar getEndDateHigh() {
		return endDateHigh;
	}

	@TypeConversion(converter="com.th5.struts.others.StringToCalendarConverter")
	public void setEndDateHigh(Calendar endDateHigh) {
		this.endDateHigh = endDateHigh;
	}

	public ArrayList<String> getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(ArrayList<String> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
}
