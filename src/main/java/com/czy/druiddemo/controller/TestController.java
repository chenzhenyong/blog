package com.czy.druiddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 10:33 2018/7/2
*/

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    public String hello(){
        return "hello";
    }
}
