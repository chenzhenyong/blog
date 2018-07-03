package com.czy.druiddemo.service;

import com.czy.druiddemo.entity.UserEntity;
import com.czy.druiddemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 9:06 2018/6/8
*/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public UserEntity getUserByUserId(String id){
        try {
            return userMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserEntity> getAllUsers() {
        return userMapper.getAll();
    }
}
