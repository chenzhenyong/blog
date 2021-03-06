package com.ithub.blog.mapper;

import com.ithub.blog.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 9:48 2018/6/11
*/
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{userId}")
    UserEntity getOne(Long userId);

    @Select("SELECT * FROM user")
    List<UserEntity> getAll();

}
