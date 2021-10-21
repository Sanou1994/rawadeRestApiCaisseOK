package com.app.metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Soldereel implements Serializable{
	private static final long serialVersionUID = 1L;
	private double caisse;
	private double orange;
	private double expresso;
	private double freemoney;
	private double wari;
	private double wizall;
	private double proximo;
	private double xpress;
	private double banque;
	private double yup;
	private double wave;
	private double cloturer;
	@Column(name="sommeinitiale")
	private double sommeInitiale;
	private String date;
	private int status = 1;
	private int idU;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public Soldereel() {
		super();
	}
	public Soldereel(double caisse, double orange, double expresso, double freemoney, double wari, double wizall,
			double proximo, double xpress, double banque, double yup, double wave, double cloturer,
			double sommeInitiale, String date, int status, int idU, int id) {
		super();
		this.caisse = caisse;
		this.orange = orange;
		this.expresso = expresso;
		this.freemoney = freemoney;
		this.wari = wari;
		this.wizall = wizall;
		this.proximo = proximo;
		this.xpress = xpress;
		this.banque = banque;
		this.yup = yup;
		this.wave = wave;
		this.cloturer = cloturer;
		this.sommeInitiale = sommeInitiale;
		this.date = date;
		this.status = status;
		this.idU = idU;
		this.id = id;
	}
	public double getCaisse() {
		return caisse;
	}
	public void setCaisse(double caisse) {
		this.caisse = caisse;
	}
	public double getOrange() {
		return orange;
	}
	public void setOrange(double orange) {
		this.orange = orange;
	}
	public double getExpresso() {
		return expresso;
	}
	public void setExpresso(double expresso) {
		this.expresso = expresso;
	}
	public double getFreemoney() {
		return freemoney;
	}
	public void setFreemoney(double freemoney) {
		this.freemoney = freemoney;
	}
	public double getWari() {
		return wari;
	}
	public void setWari(double wari) {
		this.wari = wari;
	}
	public double getWizall() {
		return wizall;
	}
	public void setWizall(double wizall) {
		this.wizall = wizall;
	}
	public double getProximo() {
		return proximo;
	}
	public void setProximo(double proximo) {
		this.proximo = proximo;
	}
	public double getXpress() {
		return xpress;
	}
	public void setXpress(double xpress) {
		this.xpress = xpress;
	}
	public double getBanque() {
		return banque;
	}
	public void setBanque(double banque) {
		this.banque = banque;
	}
	public double getYup() {
		return yup;
	}
	public void setYup(double yup) {
		this.yup = yup;
	}
	public double getWave() {
		return wave;
	}
	public void setWave(double wave) {
		this.wave = wave;
	}
	public double getCloturer() {
		return cloturer;
	}
	public void setCloturer(double cloturer) {
		this.cloturer = cloturer;
	}
	public double getSommeInitiale() {
		return sommeInitiale;
	}
	public void setSommeInitiale(double sommeInitiale) {
		this.sommeInitiale = sommeInitiale;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
