package com.wu.mike.react.cassandra.controller;

import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.service.VideosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/videos")
public class VideosController {

    VideosService videosService;

    @PostMapping
    public Mono<Video> addVideo(@RequestBody @Valid Mono<Video> videoMono) {
        return videosService.addVideo(videoMono);
    }

    @GetMapping
    public Flux<Video> getVideos() {
        return videosService.getVideos();
    }

    @PutMapping
    public Mono<Video> saveVideo(@RequestBody Mono<Video> video) {
        return videosService.updateVideo(video);
    }

    @DeleteMapping("/{videoId}")
    public Mono<Void> deleteVideo(@PathVariable UUID videoId) {
        return videosService.deleteVideo(videoId);
    }

    @DeleteMapping
    public Mono<Void> deleteVideos() {
        return videosService.deleteAllVideos();
    }
}