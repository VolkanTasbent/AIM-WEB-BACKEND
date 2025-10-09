package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servisler")
public class Servis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private String ozet;
    private String detay;
    private String resimUrl;
    private Boolean aktif = true;

    // Getter-Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getOzet() { return ozet; }
    public void setOzet(String ozet) { this.ozet = ozet; }

    public String getDetay() { return detay; }
    public void setDetay(String detay) { this.detay = detay; }

    public String getResimUrl() { return resimUrl; }
    public void setResimUrl(String resimUrl) { this.resimUrl = resimUrl; }

    public Boolean getAktif() { return aktif; }
    public void setAktif(Boolean aktif) { this.aktif = aktif; }
}
