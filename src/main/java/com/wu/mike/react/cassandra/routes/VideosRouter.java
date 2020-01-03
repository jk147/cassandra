package com.wu.mike.react.cassandra.routes;

import com.wu.mike.react.cassandra.handler.VideosHandler;
import com.wu.mike.react.cassandra.service.VideosService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@AllArgsConstructor
@Configuration
public class VideosRouter {

    VideosService videosService;

    @Bean
    RouterFunction<ServerResponse> routes(VideosHandler handler) {
        return route(GET("/router-video").and(accept(APPLICATION_JSON)), handler::getVideos)
                .andRoute(GET("/router-video/{videoId}").and(accept(APPLICATION_JSON)), handler::getVideo)
                .andRoute(POST("/router-video").and(accept(APPLICATION_JSON)), handler::addVideo)
                .andRoute(DELETE("/router-video").and(accept(APPLICATION_JSON)), handler::deleteVideo);
    }
}
