package com.example.facturation.controller;

import com.example.facturation.entity.Virement;
import com.example.facturation.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class VirementController {

    @Autowired
    private VirementService virementService;

    @PostMapping("/virements")
    public Virement saveVirement(@RequestBody Virement virement){
        return virementService.saveVirement(virement);
    }

    @GetMapping("/virements")
    public List<Virement> getVirements(){
        return virementService.getVirements();
    }

    @GetMapping("/virements/{id}")
    public Virement getVirementById(@PathVariable Integer id){
        return virementService.getVirementById(id);
    }

    @DeleteMapping("/virements/{id}")
    public void deleteVirement(@PathVariable Integer id){
        virementService.deleteVirement(id);
    }

    @PutMapping("/virements/{id}")
    public Virement updateVirement(@PathVariable Integer id, @RequestBody Virement virement) {
        return virementService.updateVirement(id, virement);
    }
}
