package com.example.facturation.service;

import com.example.facturation.dao.FactureDao;
import com.example.facturation.entity.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactureService {

    @Autowired
    private FactureDao factureDao;

    public Facture saveFacture(Facture facture) {
        return factureDao.save(facture);
    }

    public List<Facture> getFactures() {
        List<Facture> factures = new ArrayList<>();
        factureDao.findAll().forEach(factures::add);
        return factures;
    }

    public Facture getFactureById(Integer id) {
        return factureDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id: " + id));
    }

    public void deleteFacture(Integer id) {
        factureDao.deleteById(id);
    }

    public Facture updateFacture(Integer id, Facture factureDetails) {
        Facture facture = factureDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id: " + id));

        //facture.setClient_id(factureDetails.getClient_id());
        facture.setNumerofact(factureDetails.getNumerofact());
        facture.setMontant(factureDetails.getMontant());
        facture.setDatefac(factureDetails.getDatefac());
        facture.setEtat(factureDetails.getEtat());

        return factureDao.save(facture);
    }

    public List<Facture> getFacturesByClientId(Integer clientId) {
        return factureDao.findByClientId(clientId);
    }

}
