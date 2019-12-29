package com.wu.mike.react.cassandra.handler;


import com.wu.mike.react.cassandra.model.Video;
import com.wu.mike.react.cassandra.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class VideosHandler {
    private VideosRepository videosRepository;

    public Flux<Video> getVideos(ServerRequest serverRequest) {
        Mono<Video> video = serverRequest.bodyToMono(Video.class);
        return videosRepository.findAll();
    }

    public Mono<Video> addVideo(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Video.class)
                .flatMap(video -> videosRepository.save(video));
    }
}
