/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 6 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;

public class Product {

	private int productId;
	private String name;
	private String description;
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Product(int productId, String name, String description) {
		this(name, description);
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
