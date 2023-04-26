package com.zhaokun.springneo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.List;

/**
 * @author zhaok
 * @Date 2023/4/25 17:00
 */
@Data
@NodeEntity(label = "Model")
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String modelId;

    @Relationship(type = "FIELDRELATION")
    private List<String> relationShipId;

}