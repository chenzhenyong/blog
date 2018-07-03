package com.czy.druiddemo.entity;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 9:48 2018/6/11
*/
public class UserEntity {
    private Long id;
    private String email;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
