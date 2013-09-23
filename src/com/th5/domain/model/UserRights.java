package com.th5.domain.model;

public enum UserRights {
    BLOCKED(0), INACTIVE(1), USER(5), MODDERATOR(128), ADMIN(256);
    
    private int rightsValue;
    
    private UserRights(int rightsValue){
    	this.rightsValue = rightsValue;
    }
    
    public static UserRights fromInteger(int x) {
        switch(x) {
        case 0:
            return BLOCKED;
        case 1:
            return INACTIVE;
        case 5:
            return USER;
        case 128:
            return MODDERATOR;
        case 256:
            return ADMIN;
        }
        return null;
    }
    
    public int getRightsValue(){
    	return rightsValue;
    }
}