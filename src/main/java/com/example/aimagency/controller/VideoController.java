package com.example.aimagency.controller;

import com.example.aimagency.model.Video;
import com.example.aimagency.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "http://localhost:3000")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // 🔹 Tüm videoları getir
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    // 🔹 ID'ye göre video getir
    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    // 🔹 Yeni video ekle
    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    // 🔹 Video sil
    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }

    // 🔹 Video güncelle
    @PutMapping("/{id}")
    public Video updateVideo(@PathVariable Long id, @RequestBody Video updatedVideo) {
        return videoService.updateVideo(id, updatedVideo);
    }
}
