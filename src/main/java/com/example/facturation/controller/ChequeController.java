package com.example.facturation.controller;

import com.example.facturation.entity.Cheque;
import com.example.facturation.service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
@CrossOrigin(origins = "http://localhost:4200")
public class ChequeController {

    @Autowired
    private ChequeService chequeService;

    @GetMapping
    public ResponseEntity<List<Cheque>> getAllCheques() {
        List<Cheque> cheques = chequeService.findAllCheques();
        return ResponseEntity.ok(cheques);
    }

    @PostMapping
    public ResponseEntity<Cheque> createCheque(@RequestBody Cheque cheque) {
        Cheque createdCheque = chequeService.createCheque(cheque);
        return ResponseEntity.ok(createdCheque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cheque> updateCheque(@PathVariable Long id, @RequestBody Cheque cheque) {
        if (!chequeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cheque.setId(id);
        Cheque updatedCheque = chequeService.save(cheque);
        return ResponseEntity.ok(updatedCheque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheque(@PathVariable Long id) {
        chequeService.deleteCheque(id);
        return ResponseEntity.noContent().build();
    }
}
