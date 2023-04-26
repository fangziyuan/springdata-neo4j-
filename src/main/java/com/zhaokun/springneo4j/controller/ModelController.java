package com.zhaokun.springneo4j.controller;

import com.zhaokun.springneo4j.service.ModelServiceImpl;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaok
 * @Date 2023/4/25 16:51
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelServiceImpl modelService;

    @PostMapping("/selectAll")
    public Result queryModelInfo() {
        return modelService.queryModelInfo();
    }

}