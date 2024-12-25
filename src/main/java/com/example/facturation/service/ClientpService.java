package com.example.facturation.service;

import com.example.facturation.dao.ClientpDao;
import com.example.facturation.entity.Clientp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientpService {

    @Autowired
    private ClientpDao clientpDao;

    public Clientp saveClientp(Clientp clientp) {
        return clientpDao.save(clientp);
    }

    public List<Clientp> getClientsp() {
        List<Clientp> clientsp = new ArrayList<>();
        clientpDao.findAll().forEach(clientsp::add);
        return clientsp;
    }

    public Clientp getClientsp(Integer clientpId) {
        return clientpDao.findById(clientpId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientpId));
    }

    public void deleteClientp(Integer clientpId) {
        clientpDao.deleteById(clientpId);
    }

    public Clientp updateClientp(Integer id, Clientp clientpDetails) {
        Clientp clientp = clientpDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));

        clientp.setNom(clientpDetails.getNom());
        clientp.setMf(clientpDetails.getMf());
        clientp.setTel(clientpDetails.getTel());
        clientp.setAdresse(clientpDetails.getAdresse());
        clientp.setPrenom(clientpDetails.getPrenom());
        clientp.setCin(clientpDetails.getCin());

        return clientpDao.save(clientp);
    }

    public boolean existsById(Integer clientpId) {
        return clientpDao.existsById(clientpId);
    }
}
