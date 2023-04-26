package com.zhaokun.springneo4j.dao;

import com.zhaokun.springneo4j.entity.Model;
import com.zhaokun.springneo4j.entity.Movie;
import org.neo4j.ogm.model.Result;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaok
 * @Date 2023/4/25 17:00
 */
@Repository
public interface ModelDao extends CrudRepository<Model, Long> {

    /**
     * 通过名称查询person
     * @param name
     * @return
     */
    @Query("match(m:Model)-[:FIELDRELATION]->(f) return m,f")
    Result queryModelInfo();

    /**
     * 创建节点
     * @param modelId
     * @return
     */
    @Query("CREATE" +
            "(model:Model {modelId: {0}})")
    Result createModelLab(String modelId);

    /**
     * 创建两个节点直接的关系
     * @param modelId1
     * @param modelId2
     * @param relationId
     * @return
     */
    @Query("MATCH(model1:Model {modelId: {0}})," +
            "(model2:Model {modelId: {1}})" +
            "CREATE (model1)-[:FIELDRELATION {relationId: {2}}]->(model2)")
    Result createModelRelation(String modelId1, String modelId2, String relationId);


    /**
     * 模型删除关系
     * @param model1 模型id
     * @param model2 模型id
     * @return
     */
    @Query("MATCH(model1:Model {modelId: {0}})-[rel:FIELDRELATION]-" +
            "(model2:Model {modelId: {1}})" +
            "DELETE rel")
    Result deleteModelRelation(String model1, String model2);
}