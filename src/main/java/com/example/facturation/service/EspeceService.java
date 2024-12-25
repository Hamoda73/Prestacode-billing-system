package com.example.facturation.service;

import com.example.facturation.dao.EspeceDao;
import com.example.facturation.entity.Espece;
import com.example.facturation.entity.Virement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspeceService {

    @Autowired
    private EspeceDao especeRepository;

    public List<Espece> getAllEspeces() {
        return especeRepository.findAll();
    }

    public Optional<Espece> getEspeceById(Integer id) {
        return especeRepository.findById(id);
    }

    public Espece saveEspece(Espece espece) {
        return especeRepository.save(espece);
    }

    public void deleteEspece(Integer id) {
        especeRepository.deleteById(id);
    }

    public Espece updateEspece(Integer id, Espece especeDetails) {
        Espece espece = especeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espece not found with id: " + id));

        espece.setFacture_id(especeDetails.getFacture_id());
        espece.setMontant(especeDetails.getMontant());
        espece.setEcheance(especeDetails.getEcheance());
        espece.setObservation(especeDetails.getObservation());

        return especeRepository.save(espece);
    }


}
