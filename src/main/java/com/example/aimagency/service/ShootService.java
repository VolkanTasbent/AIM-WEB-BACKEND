package com.example.aimagency.service;

import com.example.aimagency.model.Shoot;
import com.example.aimagency.repository.ShootRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShootService {
    private final ShootRepository shootRepository;

    public ShootService(ShootRepository shootRepository) {
        this.shootRepository = shootRepository;
    }

    public List<Shoot> getAllShoots() {
        return shootRepository.findAll();
    }

    public Shoot getShootById(Long id) {
        return shootRepository.findById(id).orElse(null);
    }

    public Shoot saveShoot(Shoot shoot) {
        return shootRepository.save(shoot);
    }

    public void deleteShoot(Long id) {
        shootRepository.deleteById(id);
    }

    public Shoot updateShoot(Long id, Shoot updatedShoot) {
        return shootRepository.findById(id).map(shoot -> {
            shoot.setTitle(updatedShoot.getTitle());
            shoot.setImageUrl(updatedShoot.getImageUrl());
            shoot.setDescription(updatedShoot.getDescription());
            return shootRepository.save(shoot);
        }).orElse(null);
    }
}
