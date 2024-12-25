package com.example.facturation.controller;

import com.example.facturation.entity.Clientp;
import com.example.facturation.service.ClientpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ClientpController {

    @Autowired
    private ClientpService clientpService;

    @PostMapping("/clientsp")
    public Clientp saveClientp(@RequestBody Clientp clientp){
        return clientpService.saveClientp(clientp);
    }

    @GetMapping("/clientsp")
    public List<Clientp> getClientsp(){
        return clientpService.getClientsp();
    }

    @GetMapping("/clientsp/{id}")
    public Clientp getClientpById(@PathVariable Integer id){
        return clientpService.getClientsp(id);
    }

    @DeleteMapping("/clientsp/{id}")
    public void deleteClientp(@PathVariable Integer id){
        clientpService.deleteClientp(id);
    }

    @PutMapping("/clientsp/{id}")
    public Clientp updateClientp(@PathVariable Integer id, @RequestBody Clientp clientp) {
        return clientpService.updateClientp(id, clientp);
    }


}
