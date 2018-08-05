package com.ithub.blog;

import com.ithub.blog.entity.ConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConfig {

    @Autowired
    private ConfigTest test;

    @Test
    public void test() {
        System.out.println(test.getStr());
    }
}
