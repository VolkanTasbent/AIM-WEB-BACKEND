package com.example.aimagency.controller;

import com.example.aimagency.model.Servis;
import com.example.aimagency.service.ServisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servisler")
@CrossOrigin(origins = "*")
public class ServisController {

    private final ServisService service;

    public ServisController(ServisService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servis> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Servis add(@RequestBody Servis servis) {
        return service.save(servis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
