package com.ctrenka.spring_mongodb_mysql_auth.controller;

import com.ctrenka.spring_mongodb_mysql_auth.controller.auth.UserCredential;
import com.ctrenka.spring_mongodb_mysql_auth.model.Person;
import com.ctrenka.spring_mongodb_mysql_auth.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonRepository repository;

    Logger logger = LoggerFactory.getLogger(PersonController.class);
//    @CrossOrigin("http://localhost:3001")
    @GetMapping("")
    public List<Person> Index() {
        logger.info("*********************** This is people controller index function");
        return repository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("")
    public UserCredential LoginTest(UserCredential user) {
        logger.info(user.toString());

//        return repository.findAll();
        return user;
    }
    @PostMapping("/create")
    public Person create(Person person) {
        try{
            Person result = repository.insert(person);
            return result;
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
        return new Person();
    }
}
