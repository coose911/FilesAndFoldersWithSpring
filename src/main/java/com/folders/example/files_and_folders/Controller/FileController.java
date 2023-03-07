package com.folders.example.files_and_folders.Controller;

import com.folders.example.files_and_folders.Models.File;
import com.folders.example.files_and_folders.Repository.FileRepository;
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
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getfile(@PathVariable Long id){
        Optional<File> optionalFile = fileRepository.findById(id);

        if (optionalFile.isPresent()) {
            return new ResponseEntity<>(optionalFile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalFile, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
