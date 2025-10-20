package com.example.aimagency.controller;

import com.example.aimagency.model.EsportsPlayer;
import com.example.aimagency.service.EsportsPlayerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/esports")
@CrossOrigin(origins = "*")
public class EsportsPlayerController {

    private final EsportsPlayerService service;

    public EsportsPlayerController(EsportsPlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<EsportsPlayer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EsportsPlayer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public EsportsPlayer add(@RequestBody EsportsPlayer player) {
        return service.save(player);
    }

    @PutMapping("/{id}")
    public EsportsPlayer update(@PathVariable Long id, @RequestBody EsportsPlayer updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
