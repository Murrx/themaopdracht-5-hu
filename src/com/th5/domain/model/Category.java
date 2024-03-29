package com.th5.domain.model;

import java.util.Locale;

public enum Category {
	ELECTRONICS("Electronics"), BOOKS("Books"), CARS("Cars"), OTHERS("Others");
	private String name;

	Category(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	public static Category fromString(String catagoryString) {
		try {
			return Category.valueOf(catagoryString.trim().toUpperCase(
					Locale.ENGLISH));
		} catch (Exception ex) {
			return null;
		}
	}
	
	public Boolean equals(Category category) {
		if(category.name.equals(name)) {
			return true;
		} else {
			return false;
		}
	}
}