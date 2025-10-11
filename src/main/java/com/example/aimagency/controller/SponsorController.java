package com.example.aimagency.controller;

import com.example.aimagency.model.Sponsor;
import com.example.aimagency.service.SponsorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sponsorlar")
@CrossOrigin(origins = "*")
public class SponsorController {
    private final SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping
    public List<Sponsor> getAll() {
        return sponsorService.getAll();
    }

    @PostMapping
    public Sponsor add(@RequestBody Sponsor sponsor) {
        return sponsorService.save(sponsor);
    }

    @PutMapping("/{id}")
    public Sponsor update(@PathVariable Long id, @RequestBody Sponsor updated) {
        return sponsorService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sponsorService.delete(id);
    }
}
