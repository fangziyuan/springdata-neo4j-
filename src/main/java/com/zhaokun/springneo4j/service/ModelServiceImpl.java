package com.zhaokun.springneo4j.service;

import com.zhaokun.springneo4j.dao.ModelDao;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaok
 * @Date 2023/4/25 16:52
 */
@Service
public class ModelServiceImpl {

    @Autowired
    private ModelDao modelDao;

    public Result queryModelInfo() {
        return modelDao.queryModelInfo();
    }
}