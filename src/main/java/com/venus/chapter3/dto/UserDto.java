package com.venus.chapter3.dto;

/**
 * 用户实体类
 * Created by Alan Liu on 2016/12/2 0002.
 */
public class UserDto {

    private int id;
    private String uName;
    private int uAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuAge() {
        return uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }
}
