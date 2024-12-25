package com.example.facturation.dao;

import com.example.facturation.entity.Traite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraiteDao extends JpaRepository<Traite, Integer> {


}
