package com.example.aimagency.service;

import com.example.aimagency.model.Kullanici;
import com.example.aimagency.repository.KullaniciRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {

    private final KullaniciRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public KullaniciService(KullaniciRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean dogrula(String kullaniciAdi, String sifre) {
        Kullanici kullanici = repository.findByKullaniciAdi(kullaniciAdi).orElse(null);
        if (kullanici == null) return false;
        return passwordEncoder.matches(sifre, kullanici.getSifre());
    }

    public Kullanici kaydet(String kullaniciAdi, String sifre) {
        Kullanici yeni = new Kullanici();
        yeni.setKullaniciAdi(kullaniciAdi);
        yeni.setSifre(passwordEncoder.encode(sifre));
        yeni.setRol("ADMIN");
        return repository.save(yeni);
    }
}
