package com.app.metier.entities;

public class PositionPost {
   private String date;
   private int idU;
 
   
   
public PositionPost() {
	super();
}

public PositionPost(String date, int idU) {
	super();
	this.date = date;
	this.idU = idU;
	
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public int getIdU() {
	return idU;
}

public void setId(int idU) {
	this.idU = idU;
}

  

}
