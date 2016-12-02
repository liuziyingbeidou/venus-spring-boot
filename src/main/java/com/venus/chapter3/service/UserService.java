package com.venus.chapter3.service;

import com.venus.chapter3.dto.UserDto;

/**
 * 用户Service接口
 * Created by Alan Liu on 2016/12/2 0002.
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param userDto
     */
    void create(UserDto userDto);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
