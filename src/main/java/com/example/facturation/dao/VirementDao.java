package com.example.facturation.dao;

import com.example.facturation.entity.Virement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementDao extends CrudRepository<Virement, Integer> {
}
