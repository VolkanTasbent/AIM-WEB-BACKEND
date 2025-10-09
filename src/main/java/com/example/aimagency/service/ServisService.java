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

    public Servis save(Servis s) {
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
