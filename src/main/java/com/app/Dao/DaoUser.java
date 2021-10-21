package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.metier.entities.Utilisateur;

@Repository
public interface DaoUser extends JpaRepository<Utilisateur,Integer> {
	Utilisateur findByLogin(String login);
	Utilisateur findByLoginAndPassword(String login,String password);
	Utilisateur findById(int userId);
}
