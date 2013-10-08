package com.th5.domain.model;

public enum Category {ELECTRONICS("Electronics"),BOOKS("Books"),CARS("Cars");
	private String name;
	
	Category(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}