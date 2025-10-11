package com.example.aimagency.controller;

import com.example.aimagency.model.AltServis;
import com.example.aimagency.repository.AltServisRepository;
import com.example.aimagency.service.AltServisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alt-servisler")
@CrossOrigin(origins = "*")
public class AltServisController {

    @Autowired
    private AltServisRepository repository;

    @GetMapping
    public List<AltServis> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public AltServis addAltServis(@RequestBody AltServis altServis) {
        return repository.save(altServis);
    }

    @PutMapping("/{id}")
    public AltServis updateAltServis(@PathVariable Long id, @RequestBody AltServis altServis) {
        altServis.setId(id);
        return repository.save(altServis);
    }

    @DeleteMapping("/{id}")
    public void deleteAltServis(@PathVariable Long id) {
        repository.deleteById(id);
    }
}