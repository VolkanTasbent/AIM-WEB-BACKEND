package com.example.aimagency.controller;

import com.example.aimagency.model.Haber;
import com.example.aimagency.service.HaberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/haberler", "/haberler"})
@CrossOrigin(origins = "*")
public class HaberController {

    private final HaberService service; // ✅ artık repository değil service

    public HaberController(HaberService service) {
        this.service = service;
    }

    // 🔹 TÜM HABERLERİ GETİR
    @GetMapping
    public List<Haber> getAll() {
        return service.getAll(); // ✅ service üzerinden çağrılıyor
    }

    // 🔹 ID'YE GÖRE TEK HABER GETİR
    @GetMapping("/{id}")
    public Haber getById(@PathVariable Long id) {
        return service.getById(id); // ✅ service üzerinden çağrılıyor
    }

    // 🔹 YENİ HABER EKLE
    @PostMapping
    public Haber add(@RequestBody Haber haber) {
        return service.save(haber); // ✅ service üzerinden çağrılıyor
    }

    // 🔹 HABER SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id); // ✅ service üzerinden çağrılıyor
    }

    // 🔹 HABER GÜNCELLE
    @PutMapping("/{id}")
    public Haber update(@PathVariable Long id, @RequestBody Haber haber) {
        return service.update(id, haber); // ✅ güncelleme de service içinde yapılacak
    }
}
