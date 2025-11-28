package com.example.aimagency.service;

import com.example.aimagency.model.AltServis;
import com.example.aimagency.repository.AltServisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AltServisService {

    private final AltServisRepository repository;

    public AltServisService(AltServisRepository repository) {
        this.repository = repository;
    }

    public List<AltServis> getAll() {
        return repository.findAll();
    }

    public AltServis save(AltServis altServis) {
        return repository.save(altServis);
    }

    public AltServis update(Long id, AltServis updated) {
        return repository.findById(id)
                .map(altServis -> {
                    altServis.setBaslik(updated.getBaslik());
                    altServis.setAciklama(updated.getAciklama());
                    altServis.setAktif(updated.getAktif());
                    altServis.setIkonUrl(updated.getIkonUrl());
                    return repository.save(altServis);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
