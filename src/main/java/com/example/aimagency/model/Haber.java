package com.example.aimagency.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "haberler")
public class Haber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;

    @Column(length = 500)
    private String icerik;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detay;

    private String resimUrl;

    private Boolean aktif = true;

    private LocalDate tarih = LocalDate.now();

    // --- GETTER SETTER ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getIcerik() { return icerik; }
    public void setIcerik(String icerik) { this.icerik = icerik; }

    public String getDetay() { return detay; }
    public void setDetay(String detay) { this.detay = detay; }

    public String getResimUrl() { return resimUrl; }
    public void setResimUrl(String resimUrl) { this.resimUrl = resimUrl; }

    public Boolean getAktif() { return aktif; }
    public void setAktif(Boolean aktif) { this.aktif = aktif; }

    public LocalDate getTarih() { return tarih; }
    public void setTarih(LocalDate tarih) { this.tarih = tarih; }
}