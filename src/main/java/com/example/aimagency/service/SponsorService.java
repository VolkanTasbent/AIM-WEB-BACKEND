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

    public List<Sponsor> getAll() { return repository.findAll(); }

    public Sponsor save(Sponsor sponsor) { return repository.save(sponsor); }

    public Sponsor update(Long id, Sponsor updated) {
        return repository.findById(id)
                .map(s -> {
                    s.setAd(updated.getAd());
                    s.setLogoUrl(updated.getLogoUrl());
                    s.setAktif(updated.getAktif());
                    return repository.save(s);
                })
                .orElse(null);
    }

    public void delete(Long id) { repository.deleteById(id); }
}
