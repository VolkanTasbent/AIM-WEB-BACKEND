package com.example.aimagency.controller;

import com.example.aimagency.model.Etkinlik;
import com.example.aimagency.service.EtkinlikService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etkinlikler")
@CrossOrigin(origins = "*")
public class EtkinlikController {

    private final EtkinlikService service;

    public EtkinlikController(EtkinlikService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etkinlik> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Etkinlik add(@RequestBody Etkinlik e) {
        return service.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
