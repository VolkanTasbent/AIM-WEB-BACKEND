package com.example.aimagency.controller;

import com.example.aimagency.model.Influencer;
import com.example.aimagency.service.InfluencerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
@CrossOrigin(origins = "*")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Influencer getInfluencerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return service.save(influencer);
    }

    @PutMapping("/{id}")
    public Influencer updateInfluencer(@PathVariable Long id, @RequestBody Influencer updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteInfluencer(@PathVariable Long id) {
        service.delete(id);
    }
}
