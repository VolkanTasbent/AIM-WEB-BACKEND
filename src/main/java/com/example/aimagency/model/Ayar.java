package com.example.aimagency.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ayarlar")
public class Ayar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ofisTr;
    private String ofisDe;
    private String sosyalInstagram;
    private String sosyalX;
    private String sosyalLinkedin;
    private String email;

    // Getter-Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOfisTr() { return ofisTr; }
    public void setOfisTr(String ofisTr) { this.ofisTr = ofisTr; }

    public String getOfisDe() { return ofisDe; }
    public void setOfisDe(String ofisDe) { this.ofisDe = ofisDe; }

    public String getSosyalInstagram() { return sosyalInstagram; }
    public void setSosyalInstagram(String sosyalInstagram) { this.sosyalInstagram = sosyalInstagram; }

    public String getSosyalX() { return sosyalX; }
    public void setSosyalX(String sosyalX) { this.sosyalX = sosyalX; }

    public String getSosyalLinkedin() { return sosyalLinkedin; }
    public void setSosyalLinkedin(String sosyalLinkedin) { this.sosyalLinkedin = sosyalLinkedin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
