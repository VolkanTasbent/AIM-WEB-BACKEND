package com.example.aimagency.controller;

import com.example.aimagency.model.AltServis;
import com.example.aimagency.service.AltServisService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/altservisler")
@CrossOrigin(origins = "http://localhost:3000") // React'e izin ver
public class AltServisController {

    private final AltServisService altServisService;

    public AltServisController(AltServisService altServisService) {
        this.altServisService = altServisService;
    }

    // 🔹 Tüm alt servisleri listele
    @GetMapping
    public List<AltServis> getAll() {
        return altServisService.getAll();
    }

    // 🔹 Yeni alt servis ekle
    @PostMapping
    public AltServis create(@RequestBody AltServis altServis) {
        return altServisService.create(altServis);
    }

    // 🔹 Alt servisi güncelle
    @PutMapping("/{id}")
    public AltServis update(@PathVariable Long id, @RequestBody AltServis updatedAltServis) {
        return altServisService.update(id, updatedAltServis);
    }

    // 🔹 Alt servisi sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        altServisService.delete(id);
    }
}
