package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.metier.entities.SoldeCloturerJournee;

public interface DaoSoldeCloturerJournee extends JpaRepository<SoldeCloturerJournee,Integer>{
	SoldeCloturerJournee findByIdU(int id);
	SoldeCloturerJournee findById(int userId);
	List<SoldeCloturerJournee> findByIdUAndStatus(int userId,int idU);
	List<SoldeCloturerJournee> findByIdUAndDate(int id,String date);
}
