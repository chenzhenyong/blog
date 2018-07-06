package com.ithub.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 10:33 2018/7/2
*/

@RestController
@RequestMapping("/hello")
public class TestController {

    @RequestMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/1")
    public String one(){
        return "hello 1";
    }
}
