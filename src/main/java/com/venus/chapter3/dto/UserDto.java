package com.venus.chapter3.dto;

import java.io.Serializable;

/**
 * 用户实体类
 * Created by Alan Liu on 2016/12/2 0002.
 */
public class UserDto implements Serializable {

    private int id;
    private String uCode;
    private String uName;
    private int uAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode;
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
