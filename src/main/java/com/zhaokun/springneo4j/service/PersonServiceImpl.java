package com.zhaokun.springneo4j.service;

import com.zhaokun.springneo4j.dao.PersonDao;
import com.zhaokun.springneo4j.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhaok
 * @Date 2023/4/22 15:27
 */
@Service
public class PersonServiceImpl {

    @Autowired
    private PersonDao personDao;

    public Person queryById(String id) {
        Optional<Person> personDaoById = personDao.findById(Long.parseLong(id));
        return personDaoById.orElse(null);
    }
}