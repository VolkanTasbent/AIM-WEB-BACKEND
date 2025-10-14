package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "crew")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adSoyad;
    private String unvan;

    @Column(columnDefinition = "TEXT")
    private String aciklama; // kısa açıklama

    @Column(columnDefinition = "TEXT")
    private String detay; // detay açıklama

    @Column(columnDefinition = "TEXT")
    private String resimUrl; // Cloudinary linki

    private String diller; // örn: "🇹🇷 🇬🇧 🇩🇪"
    private String linkedin;
    private String instagram;
    private String youtube;
    private String tiktok;

    private Boolean aktif = true;

    // ✅ Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public String getUnvan() { return unvan; }
    public void setUnvan(String unvan) { this.unvan = unvan; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }

    public String getDetay() { return detay; }
    public void setDetay(String detay) { this.detay = detay; }

    public String getResimUrl() { return resimUrl; }
    public void setResimUrl(String resimUrl) { this.resimUrl = resimUrl; }

    public String getDiller() { return diller; }
    public void setDiller(String diller) { this.diller = diller; }

    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

    public String getInstagram() { return instagram; }
    public void setInstagram(String instagram) { this.instagram = instagram; }

    public String getYoutube() { return youtube; }
    public void setYoutube(String youtube) { this.youtube = youtube; }

    public String getTiktok() { return tiktok; }
    public void setTiktok(String tiktok) { this.tiktok = tiktok; }

    public Boolean getAktif() { return aktif; }
    public void setAktif(Boolean aktif) { this.aktif = aktif; }
}
