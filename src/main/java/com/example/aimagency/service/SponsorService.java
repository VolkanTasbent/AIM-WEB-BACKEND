package com.example.aimagency.service;

import com.example.aimagency.model.Sponsor;
import com.example.aimagency.repository.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {

    private final SponsorRepository repository;

    public SponsorService(SponsorRepository repository) {
        this.repository = repository;
    }

    public List<Sponsor> getAll() {
        return repository.findAll();
    }

    public Sponsor save(Sponsor s) {
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
