package com.example.aimagency.service;

import com.example.aimagency.model.Etkinlik;
import com.example.aimagency.repository.EtkinlikRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtkinlikService {

    private final EtkinlikRepository repository;

    public EtkinlikService(EtkinlikRepository repository) {
        this.repository = repository;
    }

    public List<Etkinlik> getAll() {
        return repository.findAll();
    }

    public Etkinlik save(Etkinlik e) {
        return repository.save(e);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
