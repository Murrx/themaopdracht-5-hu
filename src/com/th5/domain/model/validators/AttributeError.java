/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 26 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

public class AttributeError {

	private String errorMessage;
	private String attribute;
	
	public AttributeError(String attribute, String errorMessage) {
		this.attribute = attribute;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public String getAttribute() {
		return this.attribute;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setAttribut(String attribute) {
		this.attribute = attribute;
	}
	
	public String toString() {
		return attribute + " " + errorMessage;
	}
}
