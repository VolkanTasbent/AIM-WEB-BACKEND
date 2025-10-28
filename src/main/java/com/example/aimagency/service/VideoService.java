package com.example.aimagency.service;

import com.example.aimagency.model.Video;
import com.example.aimagency.repository.VideoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        return videoRepository.findById(id).map(video -> {
            video.setTitle(updatedVideo.getTitle());
            video.setThumbnailUrl(updatedVideo.getThumbnailUrl());
            video.setVideoUrl(updatedVideo.getVideoUrl());
            video.setDescription(updatedVideo.getDescription());
            return videoRepository.save(video);
        }).orElse(null);
    }
}
