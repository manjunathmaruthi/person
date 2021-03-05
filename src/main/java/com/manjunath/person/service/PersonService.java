package com.manjunath.person.service;

import com.manjunath.person.dao.PersonDAO;
import com.manjunath.person.exception.PersonNotFoundException;
import com.manjunath.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public void addPerson(Person person)  {
        personDAO.save(person);
    }

    public void editPerson(Person person)  {
        personDAO.save(person);
    }

    public void deletePerson(Long id) throws PersonNotFoundException {

        Optional<Person> person =  personDAO.findById(id);

        if(person.isPresent()){
            personDAO.deleteById(id);
        } else {
            throw new PersonNotFoundException("No person found for given id: "+id);
        }
    }

    public long getNumberOfPersons() {
        return personDAO.findAll().stream().count();
    }

    public List<Person> getAllPersons() {
        return personDAO.findAll();
    }
}
