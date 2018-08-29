package com.bigdataxhy.test;

import com.bigdataxhy.data.DataApplication;
import javafx.application.Application;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xianghy
 * @date Created on 2018/8/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataApplication.class)
public class AppTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void test() {
        String userName = stringEncryptor.encrypt("root");
        System.out.println(userName);

        String password = stringEncryptor.encrypt("xiangHY000000");
        System.out.println(password);
    }

}
