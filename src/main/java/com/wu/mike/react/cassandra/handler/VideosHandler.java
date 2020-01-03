package com.wu.mike.react.cassandra.handler;


import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@AllArgsConstructor
@Component
public class VideosHandler {
    private VideosRepository videosRepository;

    public Mono<ServerResponse> getVideos(ServerRequest serverRequest) {
        return ok().body(videosRepository.findAll(), Video.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getVideo(ServerRequest serverRequest) {
        UUID videoId = UUID.fromString(serverRequest.pathVariable("videoId"));
        Mono<Video> video = videosRepository.findById(videoId);
        return video
                .flatMap(v -> ok().contentType(MediaType.APPLICATION_JSON).body(video, Video.class))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> addVideo(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Video.class)
                .flatMap(video -> ok().body(videosRepository.save(video), Video.class));
    }

    public Mono<ServerResponse> deleteVideo(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Video.class)
                .flatMap(video -> ok().body(videosRepository.deleteById(video.getVideoId()), Video.class));
    }
}
