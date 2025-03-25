package com.streamapp.com.video_streaming_backend.services;

import com.streamapp.com.video_streaming_backend.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface VideoService {
    // save video
    Video save(Video video, MultipartFile file);

    //get video by Id
    Video get(String videoId);

    //Get video by Title
    Video getByTitle(String title);

    //Get all video
    List<Video> getAllVideo();
}
