package com.example.aimagency.service;

import com.example.aimagency.model.Ayar;
import com.example.aimagency.repository.AyarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AyarService {

    private final AyarRepository repository;

    public AyarService(AyarRepository repository) {
        this.repository = repository;
    }

    public List<Ayar> getAll() {
        return repository.findAll();
    }

    public Ayar save(Ayar ayar) {
        return repository.save(ayar);
    }

    public Ayar update(Long id, Ayar ayar) {
        Ayar mevcut = repository.findById(id).orElseThrow();
        mevcut.setOfisTr(ayar.getOfisTr());
        mevcut.setOfisDe(ayar.getOfisDe());
        mevcut.setSosyalInstagram(ayar.getSosyalInstagram());
        mevcut.setSosyalX(ayar.getSosyalX());
        mevcut.setSosyalLinkedin(ayar.getSosyalLinkedin());
        mevcut.setEmail(ayar.getEmail());
        return repository.save(mevcut);
    }
}
