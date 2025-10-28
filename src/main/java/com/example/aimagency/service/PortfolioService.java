package com.example.aimagency.service;

import com.example.aimagency.model.Portfolio;
import com.example.aimagency.repository.PortfolioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getAllPortfolio() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    public Portfolio updatePortfolio(Long id, Portfolio updatedPortfolio) {
        return portfolioRepository.findById(id).map(portfolio -> {
            portfolio.setTeam(updatedPortfolio.getTeam());
            portfolio.setImageUrl(updatedPortfolio.getImageUrl());

            // 🔹 Logo güncelleme
            if (updatedPortfolio.getLogo() != null) {
                portfolio.setLogo(updatedPortfolio.getLogo());
            }

            return portfolioRepository.save(portfolio);
        }).orElse(null);
    }
}