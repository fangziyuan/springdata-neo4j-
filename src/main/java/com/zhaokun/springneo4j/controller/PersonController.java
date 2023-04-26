package com.zhaokun.springneo4j.controller;

import com.zhaokun.springneo4j.entity.Person;
import com.zhaokun.springneo4j.service.PersonServiceImpl;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaok
 * @Date 2023/4/22 15:25
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/id")
    public Person queryPersonById(String id) {

        return personService.queryById(id);

    }


}