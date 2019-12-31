package com.wu.mike.react.cassandra.service;

import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VideosService {

    VideosRepository videosRepository;

    public Flux<Video> getVideos() {
        return videosRepository.findAll();
    }

    public Mono<Video> addVideo(Mono<Video> videoMono) {
        return videoMono.flatMap(video -> videosRepository.insert(video));
    }

    public Mono<Video> updateVideo(Mono<Video> videoMono) {
        Mono<Video> existingVideo = videoMono.flatMap(video -> videosRepository.findById(video.getVideoId()));
        return videoMono.zipWith(existingVideo, (vid, existingVid) -> new Video());
    }

    public Mono<Void> deleteVideo(UUID id) {
        return videosRepository.deleteById(id);
    }

    public Mono<Void> deleteAllVideos() {
        return videosRepository.deleteAll();
    }
}
