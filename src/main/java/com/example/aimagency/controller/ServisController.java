package com.example.aimagency.controller;

import com.example.aimagency.model.Servis;
import com.example.aimagency.service.ServisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/servisler", "/servisler"})
@CrossOrigin(origins = "*")
public class ServisController {

    private final ServisService service;

    public ServisController(ServisService service) {
        this.service = service;
    }

    // 🔹 TÜM SERVİSLERİ LİSTELE
    @GetMapping
    public List<Servis> getAll() {
        return service.getAll();
    }

    // 🔹 ID'YE GÖRE SERVİS GETİR (DETAY SAYFASI İÇİN)
    @GetMapping("/{id}")
    public ResponseEntity<Servis> getById(@PathVariable Long id) {
        Servis servis = service.getById(id);
        if (servis != null) {
            return ResponseEntity.ok(servis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 YENİ SERVİS EKLE
    @PostMapping
    public Servis add(@RequestBody Servis servis) {
        return service.save(servis);
    }

    // 🔹 SERVİS GÜNCELLE
    @PutMapping("/{id}")
    public ResponseEntity<Servis> update(@PathVariable Long id, @RequestBody Servis updated) {
        Servis servis = service.update(id, updated);
        return servis != null ? ResponseEntity.ok(servis) : ResponseEntity.notFound().build();
    }

    // 🔹 SERVİS SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}