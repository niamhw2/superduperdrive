package com.services;

import com.mappers.FileMapper;
import com.model.File;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating FileService bean");
    }

    public List<File> getFiles() {
        return fileMapper.getAllFiles();
    }

    public void addFile(File file){
        fileMapper.insertFile(file);
    }
}
