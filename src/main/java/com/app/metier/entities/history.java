package com.app.metier.entities;

public class history {
	private int id;
	private String date ;
	private String date1 ;
	public history() {
		super();
	}
	public history(int id, String date, String date1) {
		super();
		this.id = id;
		this.date = date;
		this.date1 = date1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	

}
