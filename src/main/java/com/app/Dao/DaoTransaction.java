package com.app.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.metier.entities.Transaction;
@Repository
public interface DaoTransaction extends JpaRepository<Transaction,Integer>{
	Transaction findById(int userId);
	List<Transaction> findByIdUAndDateAndStatus(int idU,String date,int status);
	List<Transaction> findByDateAndOperateurAndSensAndIdU(String date,String operateur,String sens,int id);
	List<Transaction> findByOperateurAndDateAndIdUAndSensAndStatus(String operateur,String operation,int id,String date,int id1);
	List<Transaction> findByOperateurAndDateAndIdUAndStatus(String operation,String date,int id,int id1);
	List<Transaction> findBySensAndDateAndIdUAndStatus(String sens,String date,int id,int id1);
	List<Transaction> findByFraisAndDateAndIdUAndStatus(String sens,String date,int id,int id1);
	List<Transaction> findByIdUAndDateBetween(int idU,String date,String operateur);
	List<Transaction> findByOperateurAndOperationAndDateAndIdU(String operation,String operatio,String date,int id);

	
}
