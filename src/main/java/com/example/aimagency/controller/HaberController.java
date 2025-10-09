package com.example.aimagency.controller;

import com.example.aimagency.model.Haber;
import com.example.aimagency.service.HaberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/haberler")
@CrossOrigin(origins = "*")
public class HaberController {

    private final HaberService service;

    public HaberController(HaberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Haber> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Haber add(@RequestBody Haber haber) {
        return service.save(haber);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
