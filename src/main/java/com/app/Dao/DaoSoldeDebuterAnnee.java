package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.metier.entities.SoldeDebuterAnnee;
import com.app.metier.entities.Soldereel;

public interface DaoSoldeDebuterAnnee extends JpaRepository<SoldeDebuterAnnee,Integer>{
	SoldeDebuterAnnee findByIdU(int id);
	SoldeDebuterAnnee findById(int userId);
	List<SoldeDebuterAnnee> findByIdUAndStatus(int userId,int idU);
	List<SoldeDebuterAnnee> findByIdUAndDate(int id,String date);
}
