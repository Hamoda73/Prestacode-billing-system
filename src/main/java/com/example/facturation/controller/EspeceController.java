package com.example.facturation.controller;

import com.example.facturation.entity.Espece;
import com.example.facturation.service.EspeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/especes")
@CrossOrigin(origins = "http://localhost:4200")
public class EspeceController {

    @Autowired
    private EspeceService especeService;

    @GetMapping
    public List<Espece> getAllEspeces() {
        return especeService.getAllEspeces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espece> getEspeceById(@PathVariable Integer id) {
        Optional<Espece> espece = especeService.getEspeceById(id);
        return espece.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Espece createEspece(@RequestBody Espece espece) {
        return especeService.saveEspece(espece);
    }

    @PutMapping("/{id}")
    public Espece updateEspece(@PathVariable Integer id, @RequestBody Espece espece) {
        return especeService.updateEspece(id, espece);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspece(@PathVariable Integer id) {
        if (especeService.getEspeceById(id).isPresent()) {
            especeService.deleteEspece(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
