package com.example.facturation.dao;

import com.example.facturation.entity.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeDao extends JpaRepository<Cheque, Long> {
}
