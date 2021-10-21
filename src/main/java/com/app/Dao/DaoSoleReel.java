package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.metier.entities.Soldereel;

public interface DaoSoleReel extends JpaRepository<Soldereel,Integer>{
	Soldereel findByIdU(int id);
	Soldereel findById(int userId);
	List<Soldereel> findByIdUAndStatus(int userId,int idU);
	List<Soldereel> findByIdUAndDate(int id,String date);
}
