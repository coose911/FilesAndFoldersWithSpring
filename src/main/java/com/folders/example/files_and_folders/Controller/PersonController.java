package com.folders.example.files_and_folders.Controller;


import com.folders.example.files_and_folders.Models.Person;
import com.folders.example.files_and_folders.Repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PeopleRepository peopleRepository;

    @GetMapping(value = "/person")
    public ResponseEntity<List<Person>> getAllPeople() {
        return new ResponseEntity<>(peopleRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id){
        Optional<Person> optionalPerson = peopleRepository.findById(id);

        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(optionalPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalPerson, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person){
        peopleRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
