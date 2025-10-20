package com.exemple.smartLogi.model;

import com.exemple.smartLogi.model.enums.ColisStatut;
import jakarta.persistence.*;

@Entity
@Table(name = "colis")
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String destinataire;
    private String adresse;
    private double poids;
    @Enumerated(EnumType.STRING)
    private ColisStatut  statut;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLivreur")
    private Livreur livreur;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public ColisStatut getStatut() {
        return statut;
    }

    public void setStatut(ColisStatut statut) {
        this.statut = statut;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
