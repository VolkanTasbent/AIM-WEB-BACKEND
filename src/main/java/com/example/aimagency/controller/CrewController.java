package com.example.aimagency.controller;

import com.example.aimagency.model.Crew;
import com.example.aimagency.service.CrewService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/crew")
@CrossOrigin(origins = "*")
public class CrewController {

    private final CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    // 🔹 TÜM EKİP ÜYELERİNİ GETİR
    @GetMapping
    public List<Crew> getAll() {
        return crewService.getAllCrew();
    }

    // 🔹 TEK EKİP ÜYESİ GETİR
    @GetMapping("/{id}")
    public Crew getById(@PathVariable Long id) {
        return crewService.getCrewById(id);
    }

    // 🔹 YENİ EKLE
    @PostMapping
    public Crew add(@RequestBody Crew crew) {
        return crewService.addCrew(crew);
    }

    // 🔹 GÜNCELLE
    @PutMapping("/{id}")
    public Crew update(@PathVariable Long id, @RequestBody Crew crew) {
        return crewService.updateCrew(id, crew);
    }

    // 🔹 SİL
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        crewService.deleteCrew(id);
    }
}