package com.example.facturation.dao;

import com.example.facturation.entity.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends CrudRepository<Facture, Integer> {
    List<Facture> findByClientId(Integer clientId);
}

