package com.exemple.smartLogi.service.coli;

import com.exemple.smartLogi.model.Colis;
import com.exemple.smartLogi.repository.ColiRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ColisServiceImpl  implements ColisService{

    private ColiRepository coliRepository;

    @Override
    @Transactional
    public Colis addColis(Colis colis) {
        return coliRepository.save(colis);
    }

    @Override
    @Transactional
    public Colis modifier(Colis colis) {
        return coliRepository.save(colis);
    }

    @Override
    @Transactional
    public void supprimer(String id) {
        coliRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Colis trouverParId(String id) {
        return coliRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Colis> listerTous() {
        return coliRepository.findAll();
    }

    public void setColiRepository(ColiRepository coliRepository) {
        this.coliRepository = coliRepository;
    }
}
