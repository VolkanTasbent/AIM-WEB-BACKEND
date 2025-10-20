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

    public Etkinlik getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etkinlik bulunamadı: " + id));
    }

    public Etkinlik save(Etkinlik e) {
        return repository.save(e);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Etkinlik update(Long id, Etkinlik yeniEtkinlik) {
        Etkinlik mevcut = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etkinlik bulunamadı: " + id));

        if (yeniEtkinlik.getBaslik() != null)
            mevcut.setBaslik(yeniEtkinlik.getBaslik());
        if (yeniEtkinlik.getAciklama() != null)
            mevcut.setAciklama(yeniEtkinlik.getAciklama());
        if (yeniEtkinlik.getDetay() != null)
            mevcut.setDetay(yeniEtkinlik.getDetay());
        if (yeniEtkinlik.getResimUrl() != null)
            mevcut.setResimUrl(yeniEtkinlik.getResimUrl().isEmpty() ? null : yeniEtkinlik.getResimUrl());
        if (yeniEtkinlik.getAktif() != null)
            mevcut.setAktif(yeniEtkinlik.getAktif());

        return repository.save(mevcut);
    }
}
