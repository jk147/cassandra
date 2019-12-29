package com.wu.mike.react.cassandra.service;

import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VideosService {

    VideosRepository videosRepository;

    public Flux<Video> getVideosService() {
        return videosRepository.findAll();
    }

    public Mono<Video> addVideo(Mono<Video> videoMono) {
        return videoMono.flatMap(video -> videosRepository.insert(video));
    }

    public Mono<Video> updateVideo(Mono<Video> video) {
        return video.flatMap(s -> videosRepository.save(s));
    }

    public Mono<Void> deleteVideo(String id) {
        return videosRepository.deleteById(id);
    }

    public Mono<Void> deleteAllVideos() {
        return videosRepository.deleteAll();
    }
}
