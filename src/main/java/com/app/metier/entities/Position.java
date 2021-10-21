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
@Table(name="position")
@EntityListeners(AuditingEntityListener.class)
public class Position implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idU;
	@Column(name="sommeinitiale")
	private double sommeInitiale;
	private double entree ; 
	private boolean status ; 
	private double sortie;
	@Column(name="sommefinale")
	private double sommeFinale;
	@Column(name="soldecaisse")
	private double soldeCaisse;
	@Column(name="soldejournal")
	private double soldeJournal;
	private String date;
	public Position() {
		super();
	}
	public Position(int id, int idU, double sommeInitiale, double entree, boolean status, double sortie,
			double sommeFinale, double soldeCaisse, double soldeJournal, String date) {
		super();
		this.id = id;
		this.idU = idU;
		this.sommeInitiale = sommeInitiale;
		this.entree = entree;
		this.status = status;
		this.sortie = sortie;
		this.sommeFinale = sommeFinale;
		this.soldeCaisse = soldeCaisse;
		this.soldeJournal = soldeJournal;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public double getSommeInitiale() {
		return sommeInitiale;
	}
	public void setSommeInitiale(double sommeInitiale) {
		this.sommeInitiale = sommeInitiale;
	}
	public double getEntree() {
		return entree;
	}
	public void setEntree(double entree) {
		this.entree = entree;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getSortie() {
		return sortie;
	}
	public void setSortie(double sortie) {
		this.sortie = sortie;
	}
	public double getSommeFinale() {
		return sommeFinale;
	}
	public void setSommeFinale(double sommeFinale) {
		this.sommeFinale = sommeFinale;
	}
	public double getSoldeCaisse() {
		return soldeCaisse;
	}
	public void setSoldeCaisse(double soldeCaisse) {
		this.soldeCaisse = soldeCaisse;
	}
	public double getSoldeJournal() {
		return soldeJournal;
	}
	public void setSoldeJournal(double soldeJournal) {
		this.soldeJournal = soldeJournal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
