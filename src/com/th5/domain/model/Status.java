package com.th5.domain.model;

public enum Status {BLOCKED(0), EXPIRED(2), ACTIVE(5), SPECIAL(7);
	    
	    private int rightsValue;
	    
	    private Status(int rightsValue){
	    	this.rightsValue = rightsValue;
	    }
	    
	    public static Status fromInteger(int x) {
	        switch(x) {
	        case 0:
	            return BLOCKED;
	        case 2:
	            return EXPIRED;
	        case 5:
	            return ACTIVE;
	        case 7:
	            return SPECIAL;
	        }
	        return null;
	    }
	   
	    public int getRightsValue(){
	    	return rightsValue;
	    }

}
