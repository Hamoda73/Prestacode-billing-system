package com.example.facturation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cheque")
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facture_id")
    private Long factureId;

    private float montant;
    private String echeance;
    private String observation;
    private int numero;
    private String bank;
    private String destinataire;
    private String dateV;
    private String dateNew;
    private boolean etat;
    private String piece;


    public Cheque(Long id, Long factureId, float montant, String echeance, String observation, int numero, String bank, String destinataire, String dateV, String dateNew, boolean etat, String piece) {
        this.id = id;
        this.factureId = factureId;
        this.montant = montant;
        this.echeance = echeance;
        this.observation = observation;
        this.numero = numero;
        this.bank = bank;
        this.destinataire = destinataire;
        this.dateV = dateV;
        this.dateNew = dateNew;
        this.etat = etat;
        this.piece = piece;
    }

    public Cheque() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getEcheance() {
        return echeance;
    }

    public void setEcheance(String echeance) {
        this.echeance = echeance;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getDateV() {
        return dateV;
    }

    public void setDateV(String dateV) {
        this.dateV = dateV;
    }

    public String getDateNew() {
        return dateNew;
    }

    public void setDateNew(String dateNew) {
        this.dateNew = dateNew;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
