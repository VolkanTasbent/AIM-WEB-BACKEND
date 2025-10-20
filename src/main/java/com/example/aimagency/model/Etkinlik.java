package com.example.aimagency.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "etkinlikler")
public class Etkinlik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;

    @Column(length = 500)
    private String aciklama; // kısa açıklama — örn: ana sayfada görünen

    private String resimUrl;


    @Lob
    @Column(columnDefinition = "TEXT")
    private String detay; // uzun metin — detay sayfasında gösterilecek
    private Boolean aktif = true;

    private LocalDateTime olusturmaTarihi = LocalDateTime.now();

    // Getter ve Setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }

    public String getResimUrl() { return resimUrl; }
    public void setResimUrl(String resimUrl) { this.resimUrl = resimUrl; }

    public String getDetay() { return detay; }
    public void setDetay(String detay) { this.detay = detay; }

    public Boolean getAktif() { return aktif; }
    public void setAktif(Boolean aktif) { this.aktif = aktif; }

    public LocalDateTime getOlusturmaTarihi() { return olusturmaTarihi; }
    public void setOlusturmaTarihi(LocalDateTime olusturmaTarihi) { this.olusturmaTarihi = olusturmaTarihi; }
}