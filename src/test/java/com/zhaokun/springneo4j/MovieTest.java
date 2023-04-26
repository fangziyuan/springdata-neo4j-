package com.zhaokun.springneo4j;

import com.zhaokun.springneo4j.dao.MovieDao;
import com.zhaokun.springneo4j.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

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
        for (int i = 0; i < 5; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        }

        // 6916f68d9a264cbea29c98921c0f68e4
        //3f49f5d28f684a76beb5dab8613b703b
        //493c5c9147f146fdad5f6077628f5660
        //b1c9466d2b2b491f988b0dbab32b2fcd
        //90918ed8f4364606bf3febb66f25d505
    }

}