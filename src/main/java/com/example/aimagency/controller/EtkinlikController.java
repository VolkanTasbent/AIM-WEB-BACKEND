package com.example.aimagency.controller;

import com.example.aimagency.model.Etkinlik;
import com.example.aimagency.service.EtkinlikService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/etkinlikler")
@CrossOrigin(origins = "*")
public class EtkinlikController {

    private final EtkinlikService service; // ✅ Artık Service'i kullanıyoruz

    public EtkinlikController(EtkinlikService service) {
        this.service = service;
    }

    // 🔹 1. TÜM ETKİNLİKLERİ GETİR
    @GetMapping
    public List<Etkinlik> getAll() {
        return service.getAll(); // ✅ Repository değil Service çağırılıyor
    }

    // 🔹 2. ID'ye göre TEK ETKİNLİK GETİR
    @GetMapping("/{id}")
    public Etkinlik getById(@PathVariable Long id) {
        return service.getById(id); // ✅ Service üzerinden çekiyoruz (birazdan ekleyeceğiz)
    }

    // 🔹 3. YENİ ETKİNLİK EKLE
    @PostMapping
    public Etkinlik add(@RequestBody Etkinlik etkinlik) {
        return service.save(etkinlik); // ✅ Service üzerinden kaydediyoruz
    }

    // 🔹 4. ETKİNLİK SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id); // ✅ Service üzerinden siliyoruz
    }

    // 🔹 5. ETKİNLİK GÜNCELLE
    @PutMapping("/{id}")
    public Etkinlik update(@PathVariable Long id, @RequestBody Etkinlik yeniEtkinlik) {
        return service.update(id, yeniEtkinlik); // ✅ Güncelleme işlemi Service'e taşınır
    }
}
