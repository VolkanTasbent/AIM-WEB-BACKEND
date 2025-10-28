package com.example.aimagency.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    @Autowired
    private Cloudinary cloudinary;

    // 🔹 Tekli yükleme (önceden vardı)
    @PostMapping
    public Map<String, String> uploadSingle(@RequestParam("file") MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "folder", "aimagency/portfolio"
        ));
        return Map.of("url", uploadResult.get("secure_url").toString());
    }

    // 🔹 Çoklu yükleme (12 görsel birden)
    @PostMapping("/multiple")
    public List<Map<String, String>> uploadMultiple(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "folder", "aimagency/portfolio"
            ));
            results.add(Map.of("url", uploadResult.get("secure_url").toString()));
        }
        return results;
    }
}
