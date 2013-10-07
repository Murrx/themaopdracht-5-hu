/*
 * De
veloper : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 6 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model;

public class Product {

	private int productId;
	private String productName;
	private String productDescription;
	

	private String productPhotoUrl;
	//private int prdouctCategoryId;
	
	public Product(int productId, String productName, String productDescription, String productPhotoUrl) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPhotoUrl = productPhotoUrl;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPhotoUrl() {
		return productPhotoUrl;
	}

	public void setProductPhotoUrl(String productPhotoUrl) {
		this.productPhotoUrl = productPhotoUrl;
	}
}
