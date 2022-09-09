package com.zhaokun.springneo4j.dao;

import com.zhaokun.springneo4j.entity.Person;
import org.neo4j.ogm.model.Result;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author zhaok
 * @Date 2022/9/6 20:32
 */
@Repository
public interface PersonDao extends Neo4jRepository<Person,Long> {

    /**
     * 通过名称查询person
     * @param name
     * @return
     */
    @Query("match (n:Person) where n.name = $name return n")
    Result queryByName(String name);

    /**
     *
     * @param from
     * @param relation
     * @param to
     */
//    @Query("match (n:person {name:{})")
//    void createRelation(String from, String relation, String to);


}