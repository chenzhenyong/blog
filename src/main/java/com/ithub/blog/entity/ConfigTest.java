package com.ithub.blog.entity;

import org.springframework.stereotype.Component;

/**
* @author: Chenzhenyong
* @description: 测试重写默认构造方法
* @date: Created in 11:14 2018/6/25
*/
@Component
public class ConfigTest {

    private String str;

    public ConfigTest() {
        str = "hello, world!";
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
