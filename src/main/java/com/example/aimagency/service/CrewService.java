package com.example.aimagency.service;

import com.example.aimagency.model.Crew;
import com.example.aimagency.repository.CrewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrewService {

    private final CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    // 🔹 Tüm ekip üyelerini getir
    public List<Crew> getAllCrew() {
        return crewRepository.findAll();
    }

    // 🔹 ID'ye göre getir
    public Crew getCrewById(Long id) {
        return crewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ekip üyesi bulunamadı: " + id));
    }

    // 🔹 Yeni ekip üyesi ekle
    public Crew addCrew(Crew crew) {
        return crewRepository.save(crew);
    }

    // 🔹 Güncelleme işlemi
    public Crew updateCrew(Long id, Crew yeniCrew) {
        Crew mevcut = getCrewById(id);

        if (yeniCrew.getAdSoyad() != null) mevcut.setAdSoyad(yeniCrew.getAdSoyad());
        if (yeniCrew.getUnvan() != null) mevcut.setUnvan(yeniCrew.getUnvan());
        if (yeniCrew.getAciklama() != null) mevcut.setAciklama(yeniCrew.getAciklama());
        if (yeniCrew.getDetay() != null) mevcut.setDetay(yeniCrew.getDetay());
        if (yeniCrew.getDiller() != null) mevcut.setDiller(yeniCrew.getDiller());

        if (yeniCrew.getResimUrl() != null) {
            if (yeniCrew.getResimUrl().isEmpty())
                mevcut.setResimUrl(null);
            else
                mevcut.setResimUrl(yeniCrew.getResimUrl());
        }

        if (yeniCrew.getLinkedin() != null) mevcut.setLinkedin(yeniCrew.getLinkedin());
        if (yeniCrew.getInstagram() != null) mevcut.setInstagram(yeniCrew.getInstagram());
        if (yeniCrew.getYoutube() != null) mevcut.setYoutube(yeniCrew.getYoutube());
        if (yeniCrew.getTiktok() != null) mevcut.setTiktok(yeniCrew.getTiktok());
        if (yeniCrew.getAktif() != null) mevcut.setAktif(yeniCrew.getAktif());

        return crewRepository.save(mevcut);
    }

    // 🔹 Silme işlemi
    public void deleteCrew(Long id) {
        crewRepository.deleteById(id);
    }
}
