package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adSoyad;
    private String unvan;

    @Column(columnDefinition = "TEXT")
    private String aciklama;

    private String resimUrl;
    private String youtubeTakipci;
    private String tiktokTakipci;
    private String instagramTakipci;

    // --- Getter & Setter ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getYoutubeTakipci() {
        return youtubeTakipci;
    }

    public void setYoutubeTakipci(String youtubeTakipci) {
        this.youtubeTakipci = youtubeTakipci;
    }

    public String getTiktokTakipci() {
        return tiktokTakipci;
    }

    public void setTiktokTakipci(String tiktokTakipci) {
        this.tiktokTakipci = tiktokTakipci;
    }

    public String getInstagramTakipci() {
        return instagramTakipci;
    }

    public void setInstagramTakipci(String instagramTakipci) {
        this.instagramTakipci = instagramTakipci;
    }
}
