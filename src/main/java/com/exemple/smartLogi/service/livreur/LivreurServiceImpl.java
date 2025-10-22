package com.exemple.smartLogi.service.livreur;

import com.exemple.smartLogi.model.Livreur;
import com.exemple.smartLogi.repository.LivreurRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LivreurServiceImpl implements LivreurService{

    private final LivreurRepository livreurRepository;
    public LivreurServiceImpl (LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    @Override
    @Transactional
    public Livreur addLivreur(Livreur livreur) {
       return livreurRepository.save(livreur);
    }

    @Override
    @Transactional
    public Livreur modifier(Livreur livreur) {

        return livreurRepository.save(livreur);
    }

    @Transactional
    @Override
    public void supprimer(String id) {
         livreurRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Livreur trouverParId(String id)
    {
        return livreurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Livreur> listerTous() {
        return livreurRepository.findAll();
    }
}
