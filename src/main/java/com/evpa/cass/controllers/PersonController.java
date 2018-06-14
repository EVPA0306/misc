package com.evpa.cass.controllers;

import com.evpa.cass.models.Person;
import com.evpa.cass.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    private Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/api/v1/person", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person)  {
        log.info("Execute createPerson() with {}", person);
        Person created = person.getId() == null ? personRepository.save(person.withId()) :
                personRepository.save(person);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/person", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Person>> getAllPersons() {
        log.info("Execute getAllPersons()");
        Iterable res = personRepository.findAll();
        log.info("Result: {}", res);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/persons", method = RequestMethod.POST)
    public ResponseEntity<Iterable<Person>> createPersons(@RequestBody Iterable<Person> listPersons) {
        Iterable<Person> listSaved = personRepository.save(listPersons);
        return new ResponseEntity<>(listSaved, HttpStatus.CREATED);
    }
}
