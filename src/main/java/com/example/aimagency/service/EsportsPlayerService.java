package com.example.aimagency.service;

import com.example.aimagency.model.EsportsPlayer;
import com.example.aimagency.repository.EsportsPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsportsPlayerService {

    private final EsportsPlayerRepository repository;

    public EsportsPlayerService(EsportsPlayerRepository repository) {
        this.repository = repository;
    }

    public List<EsportsPlayer> getAll() {
        return repository.findAll();
    }

    public EsportsPlayer getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public EsportsPlayer save(EsportsPlayer player) {
        return repository.save(player);
    }

    public EsportsPlayer update(Long id, EsportsPlayer updated) {
        EsportsPlayer existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setAdSoyad(updated.getAdSoyad());
        existing.setUnvan(updated.getUnvan());
        existing.setAciklama(updated.getAciklama());
        existing.setDetay(updated.getDetay());
        existing.setTakim(updated.getTakim());
        existing.setBasarilar(updated.getBasarilar());
        existing.setLinkedin(updated.getLinkedin());
        existing.setInstagram(updated.getInstagram());
        existing.setYoutube(updated.getYoutube());
        existing.setTiktok(updated.getTiktok());
        existing.setResimUrl(updated.getResimUrl());
        existing.setAchievementsBgUrl(updated.getAchievementsBgUrl());
        existing.setTeamsBgUrl(updated.getTeamsBgUrl());
        existing.setTeamLogos(updated.getTeamLogos());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
