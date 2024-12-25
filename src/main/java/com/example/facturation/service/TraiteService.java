package com.example.facturation.service;

import com.example.facturation.dao.TraiteDao;
import com.example.facturation.entity.Traite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraiteService {

    @Autowired
    private TraiteDao traiteRepository;

    public List<Traite> getAllTraites() {
        return traiteRepository.findAll();
    }

    public Optional<Traite> getTraiteById(Integer id) {
        return traiteRepository.findById(id);
    }

    public Traite saveTraite(Traite traite) {
        return traiteRepository.save(traite);
    }

    public void deleteTraite(Integer id) {
        traiteRepository.deleteById(id);
    }

    public Traite updateTraite(Integer id, Traite traiteDetails) {
        Traite traite = traiteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espece not found with id: " + id));

        traite.setFacture_id(traiteDetails.getFacture_id());
        traite.setMontant(traiteDetails.getMontant());
        traite.setEcheance(traiteDetails.getEcheance());
        traite.setObservation(traiteDetails.getObservation());

        return traiteRepository.save(traite);
    }


}
