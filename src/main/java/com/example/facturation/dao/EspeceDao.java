package com.example.facturation.dao;

import com.example.facturation.entity.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspeceDao extends JpaRepository<Espece, Integer> {


}
