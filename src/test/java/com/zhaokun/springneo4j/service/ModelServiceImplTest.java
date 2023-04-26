package com.zhaokun.springneo4j.service;

import com.alibaba.fastjson.JSONObject;
import com.zhaokun.springneo4j.dao.ModelDao;
import com.zhaokun.springneo4j.entity.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Map;

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

    @Test
    public void testQueryModelHasRelationInfo() {

        Result result = modelDao.queryModelHasRelationInfo();
        Iterable<Map<String, Object>> maps = result.queryResults();
        Iterator<Map<String, Object>> iterator = maps.iterator();

        while (iterator.hasNext()) {
            Map<String, Object> next = iterator.next();
            System.out.println(JSONObject.toJSONString(next));

            // match (model:Model)-[:FIELDRELATION]-(f) return model,f 没箭头的
            // {"f":{"id":1392,"modelId":"model_3"},"model":{"id":1390,"modelId":"model_1"}}
            // {"f":{"id":1393,"modelId":"model_4"},"model":{"id":1390,"modelId":"model_1"}}
            // {"f":{"id":1391,"modelId":"model_2"},"model":{"id":1390,"modelId":"model_1"}}
            // {"f":{"id":1390,"modelId":"model_1"},"model":{"id":1391,"modelId":"model_2"}}
            // {"f":{"id":1390,"modelId":"model_1"},"model":{"id":1392,"modelId":"model_3"}}
            // {"f":{"id":1390,"modelId":"model_1"},"model":{"id":1393,"modelId":"model_4"}}

            // match (model:Model)-[:FIELDRELATION]->(f) return model,f 有箭头的
            // {"f":{"id":1392,"modelId":"model_3"},"model":{"id":1390,"modelId":"model_1"}}
            // {"f":{"id":1393,"modelId":"model_4"},"model":{"id":1390,"modelId":"model_1"}}
            // {"f":{"id":1391,"modelId":"model_2"},"model":{"id":1390,"modelId":"model_1"}}

        }

    }

    @Test
    public void testQueryAllModelInfo() {
        Iterable<Model> all = modelDao.findAll();
        for (Model model : all) {
            System.out.println(JSONObject.toJSONString(model));

            /**
             * {"id":1390,"modelId":"model_1"}
             * {"id":1391,"modelId":"model_2"}
             * {"id":1392,"modelId":"model_3"}
             * {"id":1393,"modelId":"model_4"}
             * {"id":1550,"modelId":"3f49f5d28f684a76beb5dab8613b703b"}
             * {"id":1551,"modelId":"493c5c9147f146fdad5f6077628f5660"}
             */
        }

    }

    @Test
    public void testModelHasRelationInfoByModelId() {
        String modelId = "model_3";
        Result result = modelDao.queryModelHasRelationInfoByModelId(modelId);
        Iterable<Map<String, Object>> maps = result.queryResults();
        for (Map<String, Object> map : maps) {
            System.out.println(JSONObject.toJSONString(map));
        }
    }

}