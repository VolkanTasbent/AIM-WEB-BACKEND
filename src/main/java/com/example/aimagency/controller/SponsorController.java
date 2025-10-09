package com.example.aimagency.controller;

import com.example.aimagency.model.Sponsor;
import com.example.aimagency.service.SponsorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sponsorlar")
@CrossOrigin(origins = "*")
public class SponsorController {

    private final SponsorService service;

    public SponsorController(SponsorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sponsor> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Sponsor add(@RequestBody Sponsor sponsor) {
        return service.save(sponsor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
