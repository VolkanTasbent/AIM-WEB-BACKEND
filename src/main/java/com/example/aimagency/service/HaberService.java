package com.example.aimagency.service;

import com.example.aimagency.model.Haber;
import com.example.aimagency.repository.HaberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaberService {

    private final HaberRepository repository;

    public HaberService(HaberRepository repository) {
        this.repository = repository;
    }

    public List<Haber> getAll() {
        return repository.findAll();
    }

    public Haber save(Haber haber) {
        return repository.save(haber);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
