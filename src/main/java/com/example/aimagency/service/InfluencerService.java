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
        return repository.findById(id).orElse(null);
    }

    // 🔹 Yeni influencer ekle
    public Influencer save(Influencer influencer) {
        return repository.save(influencer);
    }

    // 🔹 Akıllı Güncelleme (boş gönderilenler silinir, null olanlar korunur)
    public Influencer update(Long id, Influencer updated) {
        Optional<Influencer> existingOpt = repository.findById(id);
        if (existingOpt.isEmpty()) return null;

        Influencer existing = existingOpt.get();

        // 🔹 Temel bilgiler
        if (updated.getAdSoyad() != null) existing.setAdSoyad(updated.getAdSoyad());
        if (updated.getUnvan() != null) existing.setUnvan(updated.getUnvan());
        if (updated.getAciklama() != null) existing.setAciklama(updated.getAciklama());
        if (updated.getDetay() != null) existing.setDetay(updated.getDetay());
        if (updated.getResimUrl() != null) existing.setResimUrl(updated.getResimUrl());

        // 🔹 Sosyal medya linkleri
        existing.setYoutube(resolveStringUpdate(existing.getYoutube(), updated.getYoutube()));
        existing.setTwitter(resolveStringUpdate(existing.getTwitter(), updated.getTwitter()));
        existing.setInstagram(resolveStringUpdate(existing.getInstagram(), updated.getInstagram()));

        // 🔹 Takipçi sayıları
        existing.setYoutubeTakipci(resolveStringUpdate(existing.getYoutubeTakipci(), updated.getYoutubeTakipci()));
        existing.setTwitterTakipci(resolveStringUpdate(existing.getTwitterTakipci(), updated.getTwitterTakipci()));
        existing.setInstagramTakipci(resolveStringUpdate(existing.getInstagramTakipci(), updated.getInstagramTakipci()));

        return repository.save(existing);
    }

    // 🔹 Silme işlemi
    public void delete(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }

    // 🧩 Yardımcı metod:
    // - null → eski değeri korur
    // - "" → siler (null yapar)
    // - diğer → günceller
    private String resolveStringUpdate(String oldVal, String newVal) {
        if (newVal == null) return oldVal; // hiç gönderilmemiş → koru
        if (newVal.trim().isEmpty()) return null; // boş string → sil
        return newVal.trim(); // normal değer → güncelle
    }
}
