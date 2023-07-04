package com.codeclan.example.managementservice.controller;

import com.codeclan.example.managementservice.models.File;
import com.codeclan.example.managementservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class FileController {

    @Autowired
    FileRepository fileRepository;


    @GetMapping(value = "/files")
    public List<File> getAllFiles(){
        return fileRepository.findAll();
    }

    @GetMapping(value = "/files/{id}")
    public Optional<File> getPirate(@PathVariable Long id){
        return fileRepository.findById(id);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postPirate(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
