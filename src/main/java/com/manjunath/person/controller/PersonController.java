package com.manjunath.person.controller;

import com.manjunath.person.exception.PersonNotFoundException;
import com.manjunath.person.model.Person;
import com.manjunath.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/", consumes = "application/json")
    public @ResponseBody HttpStatus addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public @ResponseBody HttpStatus editPerson(@PathVariable("id") long id, @RequestBody Person person){
        person.setId(id);
        personService.editPerson(person);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody HttpStatus deletePerson(@PathVariable("id") long id) throws PersonNotFoundException{
        personService.deletePerson(id);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> getNumberOfPersons() {
        return new ResponseEntity(personService.getNumberOfPersons(), null, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public @ResponseBody List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}
