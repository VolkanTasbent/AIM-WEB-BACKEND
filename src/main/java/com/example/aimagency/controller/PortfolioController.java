package com.example.aimagency.controller;

import com.example.aimagency.model.Portfolio;
import com.example.aimagency.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/portfolio", "/portfolio"})
@CrossOrigin(origins = "http://localhost:3000")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // 🔹 Tüm portföyleri getir
    @GetMapping
    public List<Portfolio> getAllPortfolio() {
        return portfolioService.getAllPortfolio();
    }

    // 🔹 ID’ye göre portföy getir
    @GetMapping("/{id}")
    public Portfolio getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    // 🔹 Yeni portföy ekle
    @PostMapping
    public Portfolio addPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.savePortfolio(portfolio);
    }

    // 🔹 Portföy sil
    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
    }

    // 🔹 Portföy güncelle
    @PutMapping("/{id}")
    public Portfolio updatePortfolio(@PathVariable Long id, @RequestBody Portfolio updatedPortfolio) {
        return portfolioService.updatePortfolio(id, updatedPortfolio);
    }
}
