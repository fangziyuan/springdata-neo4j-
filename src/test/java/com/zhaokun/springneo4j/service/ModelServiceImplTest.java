package com.zhaokun.springneo4j.service;

import com.zhaokun.springneo4j.dao.ModelDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ModelServiceImplTest {

    @Autowired
    private ModelDao modelDao;

    @Test
    public void testCreateModelLabs() {
//        String modelId = "6916f68d9a264cbea29c98921c0f68e4";
//        String modelId = "3f49f5d28f684a76beb5dab8613b703b";
        String modelId = "493c5c9147f146fdad5f6077628f5660";
        Result result = modelDao.createModelLab(modelId);
        System.out.println(result.queryResults().toString());

    }

    @Test
    public void testCreateRelation() {

        String modelId1 = "493c5c9147f146fdad5f6077628f5660";
        String modelId2 = "3f49f5d28f684a76beb5dab8613b703b";
        String relationId = "1";
        Result result = modelDao.createModelRelation(modelId1, modelId2, relationId);
        System.out.println(result.queryResults().toString());

    }

    @Test
    public void testDeleteRelation() {

        String modelId1 = "493c5c9147f146fdad5f6077628f5660";
        String modelId2 = "3f49f5d28f684a76beb5dab8613b703b";
        Result result = modelDao.deleteModelRelation(modelId1, modelId2);
        System.out.println(result.queryResults().toString());

    }

}