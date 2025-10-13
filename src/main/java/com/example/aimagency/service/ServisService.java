package com.example.aimagency.service;

import com.example.aimagency.model.Servis;
import com.example.aimagency.repository.ServisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServisService {

    private final ServisRepository repository;

    public ServisService(ServisRepository repository) {
        this.repository = repository;
    }

    // 🔹 TÜM SERVİSLER
    public List<Servis> getAll() {
        return repository.findAll();
    }

    // 🔹 ID'YE GÖRE SERVİS
    public Servis getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 🔹 SERVİS KAYDET
    public Servis save(Servis servis) {
        return repository.save(servis);
    }

    // 🔹 SERVİS GÜNCELLE
    public Servis update(Long id, Servis updated) {
        Optional<Servis> optionalServis = repository.findById(id);
        if (optionalServis.isPresent()) {
            Servis existing = optionalServis.get();
            existing.setBaslik(updated.getBaslik());
            existing.setOzet(updated.getOzet());
            existing.setDetay(updated.getDetay());
            existing.setResimUrl(updated.getResimUrl());
            existing.setAktif(updated.getAktif());
            return repository.save(existing);
        }
        return null;
    }

    // 🔹 SERVİS SİL
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
