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
@Table(name="utilisateur")
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
    private String agence;
    private String role;
    private String login;
    private String password;
    private String pseudo;
    private String nom;
    private String prenom;
    private String telephone;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Utilisateur() { }

	public Utilisateur(String agence, String role, String login, String password, String pseudo, String nom,
			String prenom, String telephone) {
		super();
		this.agence = agence;
		this.role = role;
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	public Utilisateur(String agence, String role, String login, String password, String pseudo, String nom,
			String prenom, String telephone, int id) {
		super();
		this.agence = agence;
		this.role = role;
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.id = id;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}