package com.example.aimagency.controller;

import com.example.aimagency.model.Shoot;
import com.example.aimagency.service.ShootService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoots")
@CrossOrigin(origins = "http://localhost:3000")
public class ShootController {

    private final ShootService shootService;

    public ShootController(ShootService shootService) {
        this.shootService = shootService;
    }

    // 🔹 Tüm çekimleri getir
    @GetMapping
    public List<Shoot> getAllShoots() {
        return shootService.getAllShoots();
    }

    // 🔹 ID'ye göre çekim getir
    @GetMapping("/{id}")
    public Shoot getShootById(@PathVariable Long id) {
        return shootService.getShootById(id);
    }

    // 🔹 Yeni çekim ekle
    @PostMapping
    public Shoot addShoot(@RequestBody Shoot shoot) {
        return shootService.saveShoot(shoot);
    }

    // 🔹 Çekimi sil
    @DeleteMapping("/{id}")
    public void deleteShoot(@PathVariable Long id) {
        shootService.deleteShoot(id);
    }

    // 🔹 Çekimi güncelle
    @PutMapping("/{id}")
    public Shoot updateShoot(@PathVariable Long id, @RequestBody Shoot updatedShoot) {
        return shootService.updateShoot(id, updatedShoot);
    }
}
