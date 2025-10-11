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

    // 🔹 TÜM ETKİNLİKLERİ GETİR
    @GetMapping
    public List<Etkinlik> getAll() {
        return repository.findAll();
    }

    // 🔹 YENİ ETKİNLİK EKLE
    @PostMapping
    public Etkinlik add(@RequestBody Etkinlik etkinlik) {
        return repository.save(etkinlik);
    }

    // 🔹 ETKİNLİK SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔹 ETKİNLİK GÜNCELLE
    @PutMapping("/{id}")
    public Etkinlik update(@PathVariable Long id, @RequestBody Etkinlik yeniEtkinlik) {
        Optional<Etkinlik> mevcutOpt = repository.findById(id);

        if (mevcutOpt.isEmpty()) {
            throw new RuntimeException("Etkinlik bulunamadı: " + id);
        }

        Etkinlik mevcut = mevcutOpt.get();

        // 🧩 Güncellenebilir alanlar:
        mevcut.setBaslik(yeniEtkinlik.getBaslik());
        mevcut.setAciklama(yeniEtkinlik.getAciklama());
        mevcut.setDetay(yeniEtkinlik.getDetay());

        // 🔹 Eğer frontend boş string gönderirse resmi siler
        mevcut.setResimUrl(
                (yeniEtkinlik.getResimUrl() == null || yeniEtkinlik.getResimUrl().isEmpty())
                        ? null
                        : yeniEtkinlik.getResimUrl()
        );

        mevcut.setAktif(yeniEtkinlik.getAktif());

        return repository.save(mevcut);
    }
}
