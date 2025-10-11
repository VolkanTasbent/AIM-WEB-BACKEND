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

    @GetMapping
    public List<Haber> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Haber add(@RequestBody Haber haber) {
        return repository.save(haber);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔹 GÜNCELLEME (PUT)
    @PutMapping("/{id}")
    public Haber update(@PathVariable Long id, @RequestBody Haber haber) {
        Optional<Haber> existingOpt = repository.findById(id);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Haber bulunamadı: " + id);
        }

        Haber existing = existingOpt.get();
        existing.setBaslik(haber.getBaslik());
        existing.setIcerik(haber.getIcerik()); // 💡 "icerik" alanını doğrudan kullanıyoruz
        existing.setDetay(haber.getDetay());
        existing.setResimUrl(haber.getResimUrl());
        existing.setAktif(haber.getAktif());

        return repository.save(existing);
    }
}
