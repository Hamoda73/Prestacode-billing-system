package com.example.facturation.service;

import com.example.facturation.dao.ClientDao;
import com.example.facturation.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public Client saveClient(Client client) {
        return clientDao.save(client);
    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clientDao.findAll().forEach(clients::add);
        return clients;
    }

    public Client getClients(Integer clientId) {
        return clientDao.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientId));
    }

    public void deleteClient(Integer clientId) {
        clientDao.deleteById(clientId);
    }

    public Client updateClient(Integer id, Client clientDetails) {
        Client client = clientDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));

        client.setNom(clientDetails.getNom());
        client.setMf(clientDetails.getMf());
        client.setTel(clientDetails.getTel());
        client.setAdresse(clientDetails.getAdresse());

        return clientDao.save(client);
    }

    public boolean existsById(Integer clientId) {
        return clientDao.existsById(clientId);
    }
}
