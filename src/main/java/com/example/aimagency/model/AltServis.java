package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alt_servisler")
public class AltServis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private String aciklama;

    @Column(name = "ikon_url")
    private String ikonUrl;

    private Boolean aktif = true;

    // GETTER-SETTER'LAR

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getIkonUrl() {
        return ikonUrl;
    }

    public void setIkonUrl(String ikonUrl) {
        this.ikonUrl = ikonUrl;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }
}