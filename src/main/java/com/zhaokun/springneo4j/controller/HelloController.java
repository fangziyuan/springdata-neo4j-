package com.zhaokun.springneo4j.controller;

import com.alibaba.fastjson.JSON;
import com.zhaokun.springneo4j.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaok
 * @Date 2023/1/16 20:13
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @PostMapping("/world")
    public String hello(@RequestBody Person person) {

        log.info(JSON.toJSONString(person));
        return JSON.toJSONString(person);
    }

}