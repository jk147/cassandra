package com.wu.mike.react.cassandra.repository;

import com.wu.mike.react.cassandra.model.Video;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface VideosRepository extends ReactiveCassandraRepository<Video, String> {
}
