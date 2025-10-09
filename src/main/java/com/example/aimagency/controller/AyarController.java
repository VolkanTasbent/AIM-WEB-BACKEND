package com.example.aimagency.controller;

import com.example.aimagency.model.Ayar;
import com.example.aimagency.service.AyarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayarlar")
@CrossOrigin(origins = "*")
public class AyarController {

    private final AyarService service;

    public AyarController(AyarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ayar> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Ayar add(@RequestBody Ayar ayar) {
        return service.save(ayar);
    }

    @PutMapping("/{id}")
    public Ayar update(@PathVariable Long id, @RequestBody Ayar ayar) {
        return service.update(id, ayar);
    }
}
