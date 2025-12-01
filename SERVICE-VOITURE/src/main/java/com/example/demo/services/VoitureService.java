package com.example.demo.services;

import com.example.demo.entities.Voiture;
import com.example.demo.repositories.VoitureRepository;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public Voiture enregistrerVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
}