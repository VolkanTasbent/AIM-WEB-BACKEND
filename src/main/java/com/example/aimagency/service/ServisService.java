package com.example.aimagency.service;

import com.example.aimagency.model.Servis;
import com.example.aimagency.repository.ServisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServisService {

    private final ServisRepository repository;

    public ServisService(ServisRepository repository) {
        this.repository = repository;
    }

    public List<Servis> getAll() {
        return repository.findAll();
    }

    public Servis save(Servis servis) {
        return repository.save(servis);
    }

    public Servis update(Long id, Servis updated) {
        return repository.findById(id)
                .map(servis -> {
                    servis.setBaslik(updated.getBaslik());
                    servis.setOzet(updated.getOzet());
                    servis.setDetay(updated.getDetay());
                    servis.setResimUrl(updated.getResimUrl());
                    servis.setAktif(updated.getAktif());
                    return repository.save(servis);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
