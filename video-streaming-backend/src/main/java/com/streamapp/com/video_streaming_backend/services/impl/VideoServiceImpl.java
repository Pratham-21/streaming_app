package com.streamapp.com.video_streaming_backend.services.impl;

import com.streamapp.com.video_streaming_backend.entities.Video;
import com.streamapp.com.video_streaming_backend.repositories.VideoRepository;
import com.streamapp.com.video_streaming_backend.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Value("${files.videos}")
    String DIR;

    @PostConstruct
    public void init(){
        File file = new File(DIR);

        if(!file.exists()){
            file.mkdir();
            System.out.println("Folder Created");
        }else{
            System.out.println("Folder already exist");
        }
    }

    @Override
    public Video save(Video video, MultipartFile file){
        try{
            // --> Original filename
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();

           //file path
            String cleanFileName =  StringUtils.cleanPath(filename); //--> To clean path name if there is extra "/" or anything it will be removed
            // folder path : create
            String cleanFolder = StringUtils.cleanPath(DIR);

            //folder path with filename
            Path path =  Paths.get(cleanFolder, cleanFileName); // --> This will return path of file using Folder name and File Name
            System.out.println(path);

            //copy file to the folder
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            //video metadata
            video.setContentType(contentType);
            video.setFilePath(path.toString());
            //metadata save
            return videoRepository.save(video);


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Video get(String videoId) {
        return null;
    }

    @Override
    public Video getByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAllVideo() {
        return null;
    }
}
