package com.example.aimagency.controller;

import com.example.aimagency.model.Haber;
import com.example.aimagency.repository.HaberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/haberler")
@CrossOrigin(origins = "*")
public class HaberController {

    private final HaberRepository repository;

    public HaberController(HaberRepository repository) {
        this.repository = repository;
    }

    // 🔹 TÜM HABERLERİ GETİR
    @GetMapping
    public List<Haber> getAll() {
        return repository.findAll();
    }

    // 🔹 ID'YE GÖRE TEK HABER GETİR
    @GetMapping("/{id}")
    public Haber getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Haber bulunamadı: " + id));
    }

    // 🔹 YENİ HABER EKLE
    @PostMapping
    public Haber add(@RequestBody Haber haber) {
        return repository.save(haber);
    }

    // 🔹 HABER SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔹 HABER GÜNCELLE
    @PutMapping("/{id}")
    public Haber update(@PathVariable Long id, @RequestBody Haber haber) {
        Optional<Haber> existingOpt = repository.findById(id);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Haber bulunamadı: " + id);
        }

        Haber existing = existingOpt.get();
        existing.setBaslik(haber.getBaslik());
        existing.setIcerik(haber.getIcerik());
        existing.setDetay(haber.getDetay());
        existing.setResimUrl(haber.getResimUrl());
        existing.setAktif(haber.getAktif());

        return repository.save(existing);
    }
}
