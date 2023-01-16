package com.zhaokun.springneo4j.dao;

import com.zhaokun.springneo4j.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaok
 */
@Repository
public interface MovieDao extends CrudRepository<Movie, Long> {


    /**
     * count
     * @param title
     * @return
     */
    long countByTitle(String title);
}
