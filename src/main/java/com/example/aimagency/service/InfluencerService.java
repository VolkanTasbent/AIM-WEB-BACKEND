package com.example.aimagency.service;

import com.example.aimagency.model.Influencer;
import com.example.aimagency.repository.InfluencerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfluencerService {

    private final InfluencerRepository repository;

    public InfluencerService(InfluencerRepository repository) {
        this.repository = repository;
    }

    // 🔹 Tüm influencer’ları getir
    public List<Influencer> findAll() {
        return repository.findAll();
    }

    // 🔹 ID ile getir
    public Influencer findById(Long id) {
        Optional<Influencer> influencer = repository.findById(id);
        return influencer.orElse(null);
    }

    // 🔹 Yeni influencer ekle
    public Influencer save(Influencer influencer) {
        return repository.save(influencer);
    }

    // 🔹 Güncelleme işlemi
    public Influencer update(Long id, Influencer updatedInfluencer) {
        Optional<Influencer> existingOpt = repository.findById(id);

        if (existingOpt.isEmpty()) {
            return null; // kayıt yoksa null döner
        }

        Influencer existing = existingOpt.get();
        existing.setAdSoyad(updatedInfluencer.getAdSoyad());
        existing.setUnvan(updatedInfluencer.getUnvan());
        existing.setAciklama(updatedInfluencer.getAciklama());
        existing.setResimUrl(updatedInfluencer.getResimUrl());
        existing.setYoutubeTakipci(updatedInfluencer.getYoutubeTakipci());
        existing.setTiktokTakipci(updatedInfluencer.getTiktokTakipci());
        existing.setInstagramTakipci(updatedInfluencer.getInstagramTakipci());

        return repository.save(existing);
    }

    // 🔹 Silme işlemi
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
