package com.zhaokun.springneo4j.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhaokun.springneo4j.entity.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaok
 * @Date 2023/1/16 21:04
 */
@RestController
@RequestMapping("/world")
public class WorldController {

    @PostMapping("/1")
    public String world(@RequestBody Person person) {
        return JSONObject.toJSONString(person);
    }

}