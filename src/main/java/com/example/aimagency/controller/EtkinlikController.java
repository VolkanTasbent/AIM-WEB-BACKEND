package com.example.aimagency.controller;

import com.example.aimagency.model.Etkinlik;
import com.example.aimagency.repository.EtkinlikRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etkinlikler")
@CrossOrigin(origins = "*")
public class EtkinlikController {

    private final EtkinlikRepository repository;

    public EtkinlikController(EtkinlikRepository repository) {
        this.repository = repository;
    }

    // 🔹 1. TÜM ETKİNLİKLERİ GETİR
    @GetMapping
    public List<Etkinlik> getAll() {
        return repository.findAll();
    }

    // 🔹 2. ID'ye göre TEK ETKİNLİK GETİR
    @GetMapping("/{id}")
    public Etkinlik getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etkinlik bulunamadı: " + id));
    }

    // 🔹 3. YENİ ETKİNLİK EKLE
    @PostMapping
    public Etkinlik add(@RequestBody Etkinlik etkinlik) {
        return repository.save(etkinlik);
    }

    // 🔹 4. ETKİNLİK SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔹 5. ETKİNLİK GÜNCELLE
    @PutMapping("/{id}")
    public Etkinlik update(@PathVariable Long id, @RequestBody Etkinlik yeniEtkinlik) {
        Optional<Etkinlik> mevcutOpt = repository.findById(id);

        if (mevcutOpt.isEmpty()) {
            throw new RuntimeException("Etkinlik bulunamadı: " + id);
        }

        Etkinlik mevcut = mevcutOpt.get();

        // 🧩 Boş gelmeyen alanları güncelle
        if (yeniEtkinlik.getBaslik() != null)
            mevcut.setBaslik(yeniEtkinlik.getBaslik());

        if (yeniEtkinlik.getAciklama() != null)
            mevcut.setAciklama(yeniEtkinlik.getAciklama());

        if (yeniEtkinlik.getDetay() != null)
            mevcut.setDetay(yeniEtkinlik.getDetay());

        // 🔹 RESİM GÜNCELLEME / SİLME
        if (yeniEtkinlik.getResimUrl() != null) {
            if (yeniEtkinlik.getResimUrl().isEmpty()) {
                // frontend boş string gönderirse, resmi kaldır
                mevcut.setResimUrl(null);
            } else {
                mevcut.setResimUrl(yeniEtkinlik.getResimUrl());
            }
        }

        // 🔹 Aktif alanını güvenli şekilde güncelle (null kontrolü ile)
        if (yeniEtkinlik.getAktif() != null)
            mevcut.setAktif(yeniEtkinlik.getAktif());

        return repository.save(mevcut);
    }

}
