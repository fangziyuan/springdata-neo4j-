package com.zhaokun.springneo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.io.Serializable;

/**
 * @author zhaok
 * @Date 2022/9/9 23:51
 */
@Data
@NodeEntity(label = "Movie")
public class Movie implements Serializable {

    /**
     * id>	1358
     * released	1996
     * tagline	Come as you are
     * title
     */
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private Integer released;
    @Property
    private String tagline;
    @Property
    private String title;

}