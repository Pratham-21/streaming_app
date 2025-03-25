package com.streamapp.com.video_streaming_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // --> to simplify object creation.
public class Video {
    @Id
    private String videoId;

    private String title;
    private String description;
    private String contentType;
    private String filePath;
//    @ManyToOne
//    private Course course;
}
