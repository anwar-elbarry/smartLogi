package com.exemple.smartLogi.service.livreur;

import com.exemple.smartLogi.model.Livreur;

import java.util.List;

public interface LivreurService {
    Livreur addLivreur(Livreur livreur);
    Livreur modifier(Livreur livreur);
    void supprimer(String id);
    Livreur trouverParId(String id);
    List<Livreur> listerTous();
}
