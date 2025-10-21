package com.exemple.smartLogi.repository;

import com.exemple.smartLogi.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColiRepository extends JpaRepository<Colis, String> {
}
