package com.example.aimagency.service;

import com.example.aimagency.model.AltServis;
import com.example.aimagency.repository.AltServisRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AltServisService {

    private final AltServisRepository altServisRepository;

    public AltServisService(AltServisRepository altServisRepository) {
        this.altServisRepository = altServisRepository;
    }

    // Tüm alt servisleri listele
    public List<AltServis> getAll() {
        return altServisRepository.findAll();
    }

    // Yeni alt servis ekle
    public AltServis create(AltServis altServis) {
        return altServisRepository.save(altServis);
    }

    // Alt servisi güncelle
    public AltServis update(Long id, AltServis updatedAltServis) {
        return altServisRepository.findById(id).map(existing -> {
            existing.setBaslik(updatedAltServis.getBaslik());
            existing.setAciklama(updatedAltServis.getAciklama());
            existing.setIkonUrl(updatedAltServis.getIkonUrl());
            return altServisRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Alt servis bulunamadı! ID: " + id));
    }

    // Alt servisi sil
    public void delete(Long id) {
        altServisRepository.deleteById(id);
    }
}
