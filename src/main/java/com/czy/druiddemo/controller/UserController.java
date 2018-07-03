package com.czy.druiddemo.controller;

import com.czy.druiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
* @author: Chenzhenyong
* @description: 用户控制器
* @date: Created in 9:02 2018/6/8
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return userService.getUserByUserId(id).toString();
    }

    @GetMapping("/all")
    public String all() {
        return userService.getAllUsers().toString();
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {


        return null;
    }

}
