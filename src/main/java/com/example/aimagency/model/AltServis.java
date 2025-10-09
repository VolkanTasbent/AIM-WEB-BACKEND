package com.example.aimagency.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alt_servisler")
public class AltServis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String baslik; // Başlık (örnek: Corporate Identity)

    @Column(length = 3000)
    private String aciklama; // Açıklama (örnek: Marka kimliği tasarımı...)

    private String ikonUrl; // İkon veya resim linki (isteğe bağlı)
}
