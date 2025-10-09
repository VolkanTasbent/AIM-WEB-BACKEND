package com.example.aimagency.controller;

import com.example.aimagency.service.KullaniciService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/kullanicilar")
@CrossOrigin(origins = "*")
public class KullaniciController {

    private final KullaniciService service;

    public KullaniciController(KullaniciService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        String kullaniciAdi = body.get("kullaniciAdi");
        String sifre = body.get("sifre");

        boolean dogru = service.dogrula(kullaniciAdi, sifre);
        if (dogru) {
            return "Giriş başarılı! Hoş geldin " + kullaniciAdi;
        } else {
            return "Hatalı kullanıcı adı veya şifre!";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> body) {
        String kullaniciAdi = body.get("kullaniciAdi");
        String sifre = body.get("sifre");

        service.kaydet(kullaniciAdi, sifre);
        return "Yeni admin kullanıcı başarıyla oluşturuldu!";
    }
}
