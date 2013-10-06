/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
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
}
