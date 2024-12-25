package com.example.facturation.controller;

import com.example.facturation.entity.Traite;
import com.example.facturation.service.TraiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/traites")
@CrossOrigin(origins = "http://localhost:4200")
public class TraiteController {

    @Autowired
    private TraiteService traiteService;

    @GetMapping
    public List<Traite> getAllTraites() {
        return traiteService.getAllTraites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traite> getTraiteById(@PathVariable Integer id) {
        Optional<Traite> traite = traiteService.getTraiteById(id);
        return traite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Traite createTraite(@RequestBody Traite traite) {
        return traiteService.saveTraite(traite);
    }

    @PutMapping("/{id}")
    public Traite updateTraite(@PathVariable Integer id, @RequestBody Traite traite) {
        return traiteService.updateTraite(id, traite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraite(@PathVariable Integer id) {
        if (traiteService.getTraiteById(id).isPresent()) {
            traiteService.deleteTraite(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
