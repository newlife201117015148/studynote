package com.wangle.javaIO;

import java.io.Serializable;

public class IDCard implements Serializable{
	
	/** 
	   * @Fields serialVersionUID : TODO
	   */ 
	private static final long serialVersionUID = 1L;

	public IDCard(String id){
		this.ID = id;
	}
	
	private String ID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	} 
}
