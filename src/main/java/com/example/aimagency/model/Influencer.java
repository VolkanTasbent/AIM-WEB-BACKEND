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

    private String detay;
    private String resimUrl;

    private String youtubeTakipci;
    private String twitterTakipci;
    private String instagramTakipci;

    @Column(nullable = true)
    private String youtube;

    @Column(nullable = true)
    private String twitter;

    @Column(nullable = true)
    private String instagram;

    // --- Getter & Setter ---
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

    public String getYoutubeTakipci() { return youtubeTakipci; }
    public void setYoutubeTakipci(String youtubeTakipci) { this.youtubeTakipci = youtubeTakipci; }

    public String getTwitterTakipci() { return twitterTakipci; }
    public void setTwitterTakipci(String twitterTakipci) { this.twitterTakipci = twitterTakipci; }

    public String getInstagramTakipci() { return instagramTakipci; }
    public void setInstagramTakipci(String instagramTakipci) { this.instagramTakipci = instagramTakipci; }

    public String getYoutube() { return youtube; }
    public void setYoutube(String youtube) { this.youtube = youtube; }

    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }

    public String getInstagram() { return instagram; }
    public void setInstagram(String instagram) { this.instagram = instagram; }
}
