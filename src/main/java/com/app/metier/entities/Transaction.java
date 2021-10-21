package com.app.metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private String operateur;
	private String operation;
	private double decaissement ; 
	private double commission ; 
	private double encaissement;
	private double frais;
	private double taxe;
	private double montant;
	private double surplux;
	private String numero;
	private String sens;
	private String reference;
	private String credit ;
	private String debit ;
	private int idU;
	private String date;
	private int status=1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    
	public Transaction() {
		super();
	}


	public Transaction(String operateur, String operation, double decaissement, double commission, double encaissement,
			double frais, double taxe, double montant, double surplux, String numero, String sens, String reference,
			String credit, String debit, int idU, String date,int status) {
		super();
		this.operateur = operateur;
		this.operation = operation;
		this.decaissement = decaissement;
		this.commission = commission;
		this.encaissement = encaissement;
		this.frais = frais;
		this.taxe = taxe;
		this.montant = montant;
		this.surplux = surplux;
		this.numero = numero;
		this.sens = sens;
		this.reference = reference;
		this.credit = credit;
		this.debit = debit;
		this.idU = idU;
		this.date = date;
		this.status = status;
	}


	public Transaction(String operateur, String operation, double decaissement, double commission, double encaissement,
			double frais, double taxe, double montant, double surplux, String numero, String sens, String reference,
			String credit, String debit, int idU, String date,int status,int id) {
		super();
		this.operateur = operateur;
		this.operation = operation;
		this.decaissement = decaissement;
		this.commission = commission;
		this.encaissement = encaissement;
		this.frais = frais;
		this.taxe = taxe;
		this.montant = montant;
		this.surplux = surplux;
		this.numero = numero;
		this.sens = sens;
		this.reference = reference;
		this.credit = credit;
		this.debit = debit;
		this.idU = idU;
		this.date = date;
		this.status = status;
		this.id = id;
	}


	public String getOperateur() {
		return operateur;
	}


	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public double getDecaissement() {
		return decaissement;
	}


	public void setDecaissement(double decaissement) {
		this.decaissement = decaissement;
	}


	public double getCommission() {
		return commission;
	}


	public void setCommission(double commission) {
		this.commission = commission;
	}


	public double getEncaissement() {
		return encaissement;
	}


	public void setEncaissement(double encaissement) {
		this.encaissement = encaissement;
	}


	public double getFrais() {
		return frais;
	}


	public void setFrais(double frais) {
		this.frais = frais;
	}


	public double getTaxe() {
		return taxe;
	}


	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public double getSurplux() {
		return surplux;
	}


	public void setSurplux(double surplux) {
		this.surplux = surplux;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getSens() {
		return sens;
	}


	public void setSens(String sens) {
		this.sens = sens;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getCredit() {
		return credit;
	}


	public void setCredit(String credit) {
		this.credit = credit;
	}


	public String getDebit() {
		return debit;
	}


	public void setDebit(String debit) {
		this.debit = debit;
	}


	public int getIdU() {
		return idU;
	}


	public void setIdU(int idU) {
		this.idU = idU;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
