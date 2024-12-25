package com.example.facturation.dao;

import com.example.facturation.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends CrudRepository<Client,Integer> {
}
