package com.example.facturation.controller;

import com.example.facturation.entity.Client;
import com.example.facturation.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Integer id){
        return clientService.getClients(id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }


}
