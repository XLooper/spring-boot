package com.bigdataxhy.test;

import com.bigdataxhy.data.DataApplication;
import com.bigdataxhy.data.service.RedisService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author xianghy
 * @date Created on 2018/8/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataApplication.class)
public class AppTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Resource
    RedisService redisService;

    @Test
    public void test() {
        String userName = stringEncryptor.encrypt("root");
        System.out.println(userName);

        String password = stringEncryptor.encrypt("xiangHY000000");
        System.out.println(password);
    }

    public static final String REDIS_TEST_KEY = "REDIS_TEST_KEY";
    @Test
    public void redisTest() {

        redisService.add(REDIS_TEST_KEY, "HELLO WORLD");
        System.out.println(redisService.get(REDIS_TEST_KEY));
    }
}
