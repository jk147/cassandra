package com.wu.mike.react.cassandra.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
@Table("videos")
public class Video {

    @PrimaryKey
    @Column("videoid")
    private UUID videoId;
    @Column("description")
    private String description;
    @Column("location")
    private Map<String, String> location;
    @Column("tags")
    private Set<String> tags;
    @Column("upload_date")
    private LocalDateTime uploadDate;
    @NotNull
    @Column("username")
    private String username;
    @Column("videoname")
    private String videoName;
}
