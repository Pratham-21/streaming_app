package com.streamapp.com.video_streaming_backend.repositories;

import com.streamapp.com.video_streaming_backend.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video,String>
    //JpaRepository<Data Type with which we work , Its id data type>
{
    Optional<Video> findByTitle(String title);

}
