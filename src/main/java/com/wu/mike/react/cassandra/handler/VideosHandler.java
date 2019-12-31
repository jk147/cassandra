package com.wu.mike.react.cassandra.handler;


import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class VideosHandler {
    private VideosRepository videosRepository;

    public Mono<ServerResponse> getVideos(ServerRequest serverRequest) {
        return ServerResponse.ok().body(videosRepository.findAll(), Video.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> addVideo(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Video.class)
                .flatMap(video -> ServerResponse.ok().body(videosRepository.save(video), Video.class));
    }

    public Mono<ServerResponse> deleteVideo(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Video.class)
                .flatMap(video -> ServerResponse.ok().body(videosRepository.deleteById(video.getVideoId()), Video.class));
    }
}
