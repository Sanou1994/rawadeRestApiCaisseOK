package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.metier.entities.Dates;

@Repository
public interface DaoDate extends JpaRepository<Dates,Integer>{

}
