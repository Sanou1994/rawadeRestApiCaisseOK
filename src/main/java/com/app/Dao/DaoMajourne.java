package com.app.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.metier.entities.Majournee;

@Repository
public interface DaoMajourne extends JpaRepository<Majournee,Integer> {
	Majournee findByIdUAndDateAndStatus(int id,String date ,int idU);
	Majournee findByIdSoldeDebuterJournee(int userId);
	Majournee findById(int userId);
	List<Majournee> findByIdUAndStatus(int idU,int status);
}