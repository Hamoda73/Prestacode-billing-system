package com.example.facturation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "facture")
@Getter
@Setter
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private Integer numerofact;
    private Float montant;
    private String datefac;
    private Boolean etat;

    @OneToMany(mappedBy = "factureId")
    private List<Cheque> cheques;

    public Facture() {
    }

    // Getters and setters are handled by Lombok
}
