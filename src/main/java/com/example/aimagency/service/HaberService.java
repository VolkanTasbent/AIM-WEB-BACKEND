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

    // 🔹 Tüm haberleri getir
    public List<Haber> getAll() {
        return repository.findAll();
    }

    // 🔹 ID'ye göre haber getir
    public Haber getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Haber bulunamadı: " + id));
    }

    // 🔹 Yeni haber ekle
    public Haber save(Haber haber) {
        return repository.save(haber);
    }

    // 🔹 Haber sil
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔹 Haber güncelle
    public Haber update(Long id, Haber yeniHaber) {
        Haber mevcut = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Haber bulunamadı: " + id));

        mevcut.setBaslik(yeniHaber.getBaslik());
        mevcut.setIcerik(yeniHaber.getIcerik());
        mevcut.setDetay(yeniHaber.getDetay());
        mevcut.setResimUrl(yeniHaber.getResimUrl());
        mevcut.setAktif(yeniHaber.getAktif());

        return repository.save(mevcut);
    }
}
