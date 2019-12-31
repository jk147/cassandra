package com.wu.mike.react.cassandra.repository;

import com.wu.mike.react.cassandra.model.Video;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideosRepository extends ReactiveCassandraRepository<Video, UUID> {
}
