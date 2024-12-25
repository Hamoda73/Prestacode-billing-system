package com.example.facturation.service;

import com.example.facturation.dao.ChequeDao;
import com.example.facturation.entity.Cheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChequeService {
    @Autowired
    private ChequeDao chequeRepository;

    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    public List<Cheque> findAllCheques() {
        return chequeRepository.findAll();
    }

    public Cheque save(Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    public boolean existsById(Long id) {
        return chequeRepository.existsById(id);
    }


    public Cheque getChequeById(Long id) {
        Optional<Cheque> cheque = chequeRepository.findById(id);
        return cheque.orElse(null);
    }

    public Cheque createCheque(Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    public Cheque updateCheque(Long id, Cheque chequeDetails) {
        Cheque cheque = getChequeById(id);
        if (cheque != null) {
            cheque.setFactureId(chequeDetails.getFactureId());
            cheque.setMontant(chequeDetails.getMontant());
            cheque.setEcheance(chequeDetails.getEcheance());
            cheque.setObservation(chequeDetails.getObservation());
            cheque.setNumero(chequeDetails.getNumero());
            cheque.setBank(chequeDetails.getBank());
            cheque.setDestinataire(chequeDetails.getDestinataire());
            cheque.setDateV(chequeDetails.getDateV());
            cheque.setDateNew(chequeDetails.getDateNew());
            cheque.setEtat(chequeDetails.isEtat());
            cheque.setPiece(chequeDetails.getPiece());
            return chequeRepository.save(cheque);
        }
        return null;
    }

    public void deleteCheque(Long id) {
        chequeRepository.deleteById(id);
    }
}
