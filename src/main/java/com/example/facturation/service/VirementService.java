package com.example.facturation.service;

import com.example.facturation.dao.VirementDao;
import com.example.facturation.entity.Virement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirementService {

    @Autowired
    private VirementDao virementDao;

    public Virement saveVirement(Virement virement) {
        return virementDao.save(virement);
    }

    public List<Virement> getVirements() {
        List<Virement> virements = new ArrayList<>();
        virementDao.findAll().forEach(virements::add);
        return virements;
    }

    public Virement getVirementById(Integer virementId) {
        return virementDao.findById(virementId)
                .orElseThrow(() -> new ResourceNotFoundException("Virement not found with id: " + virementId));
    }

    public void deleteVirement(Integer virementId) {
        virementDao.deleteById(virementId);
    }

    public Virement updateVirement(Integer id, Virement virementDetails) {
        Virement virement = virementDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Virement not found with id: " + id));

        virement.setFacture_id(virementDetails.getFacture_id());
        virement.setMontant(virementDetails.getMontant());
        virement.setEcheance(virementDetails.getEcheance());
        virement.setObservation(virementDetails.getObservation());
        virement.setBank(virementDetails.getBank());

        return virementDao.save(virement);
    }
}
