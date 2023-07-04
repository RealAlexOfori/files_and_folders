package com.codeclan.example.managementservice.controller;

import com.codeclan.example.managementservice.models.Person;
import com.codeclan.example.managementservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class PersonController {

    @Autowired
    PersonRepository personRepository;


    @GetMapping(value = "/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping(value = "/persons/{id}")
    public Optional<Person> getPerson(@PathVariable Long id){
        return personRepository.findById(id);
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPerson(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
