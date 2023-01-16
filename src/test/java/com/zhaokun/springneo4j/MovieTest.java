package com.zhaokun.springneo4j;

import com.zhaokun.springneo4j.dao.MovieDao;
import com.zhaokun.springneo4j.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author zhaok
 * @Date 2022/9/9 23:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieTest {

    @Autowired
    private MovieDao movieDao;

    @Test
    public void testMovie1() {
        Optional<Movie> byId = movieDao.findById(1358L);
        System.out.println(byId.orElse(null));
    }

    @Test
    public void testMovie2() {
        String title = "The Birdcage";
        long count = movieDao.countByTitle(title);
        System.out.println(count);
    }

    @Test
    public void testMovie3() {
        
    }

}