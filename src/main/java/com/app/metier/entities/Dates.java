package com.app.metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="date")
@EntityListeners(AuditingEntityListener.class)
public class Dates implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="date")
	private String Dates;
	public Dates() {
		super();
	}
	public Dates(String Dates) {
		super();
		this.Dates = Dates;
	}
	public Dates(int id, String Dates) {
		super();
		this.id = id;
		this.Dates = Dates;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDates() {
		return Dates;
	}
	public void setDates(String Dates) {
		this.Dates = Dates;
	}
	
	
	
}
