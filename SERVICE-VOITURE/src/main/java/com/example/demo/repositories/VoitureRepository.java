package com.example.demo.repositories;

import com.example.demo.entities.Client;
import com.example.demo.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByClientId(Long clientId);

}
