package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "esports")
public class EsportsPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adSoyad;
    private String unvan;

    @Column(columnDefinition = "TEXT")
    private String aciklama;

    @Column(columnDefinition = "TEXT")
    private String detay;

    @Column(columnDefinition = "TEXT")
    private String takim;

    @Column(columnDefinition = "TEXT")
    private String basarilar;




    private String linkedin;
    private String instagram;
    private String youtube;
    private String tiktok;
    private String resimUrl;


    @Column(columnDefinition = "TEXT")
    private String achievementsBgUrl;

    @Column(columnDefinition = "TEXT")
    private String teamsBgUrl;

    @Column(columnDefinition = "TEXT")
    private String teamLogos;

    // 🔹 Getter-Setter'lar
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

    public String getTakim() { return takim; }
    public void setTakim(String takim) { this.takim = takim; }

    public String getBasarilar() { return basarilar; }
    public void setBasarilar(String basarilar) { this.basarilar = basarilar; }

    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

    public String getInstagram() { return instagram; }
    public void setInstagram(String instagram) { this.instagram = instagram; }

    public String getYoutube() { return youtube; }
    public void setYoutube(String youtube) { this.youtube = youtube; }

    public String getTiktok() { return tiktok; }
    public void setTiktok(String tiktok) { this.tiktok = tiktok; }

    public String getResimUrl() { return resimUrl; }
    public void setResimUrl(String resimUrl) { this.resimUrl = resimUrl; }

    public String getAchievementsBgUrl() { return achievementsBgUrl; }
    public void setAchievementsBgUrl(String achievementsBgUrl) { this.achievementsBgUrl = achievementsBgUrl; }

    public String getTeamsBgUrl() { return teamsBgUrl; }
    public void setTeamsBgUrl(String teamsBgUrl) { this.teamsBgUrl = teamsBgUrl; }

    public String getTeamLogos() { return teamLogos; }
    public void setTeamLogos(String teamLogos) {this.teamLogos = teamLogos;}
}
