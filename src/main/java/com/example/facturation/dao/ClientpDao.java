package com.example.facturation.dao;
import com.example.facturation.entity.Clientp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientpDao extends CrudRepository<Clientp,Integer> {
}
