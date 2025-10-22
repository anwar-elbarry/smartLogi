package com.exemple.smartLogi.service.coli;

import com.exemple.smartLogi.model.Colis;

import java.util.List;

public interface ColisService {
    Colis addColis(Colis colis);
    Colis modifier(Colis colis);
    void supprimer(String id);
    Colis trouverParId(String id);
    List<Colis> listerTous();
}
