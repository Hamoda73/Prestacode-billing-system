package com.example.facturation.controller;

import com.example.facturation.entity.Facture;
import com.example.facturation.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping("/factures")
    public Facture saveFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }

    @GetMapping("/factures")
    public List<Facture> getFactures() {
        return factureService.getFactures();
    }

    @GetMapping("/factures/{id}")
    public Facture getFactureById(@PathVariable Integer id) {
        return factureService.getFactureById(id);
    }

    @DeleteMapping("/factures/{id}")
    public void deleteFacture(@PathVariable Integer id) {
        factureService.deleteFacture(id);
    }

    @PutMapping("/factures/{id}")
    public Facture updateFacture(@PathVariable Integer id, @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }
    @GetMapping("/factures/client/{clientId}")
    public List<Facture> getFacturesByClientId(@PathVariable Integer clientId) {
        return factureService.getFacturesByClientId(clientId);
    }
}
