package com.venus.chapter3.service;

import com.venus.chapter3.dto.UserDto;

import java.util.List;

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

    /**
     * 查询所有用户
     * @return
     */
    List<UserDto> queryUsers();

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    UserDto queryUserByName(String name);

    /**
     * 批量插入用户
     * @param listUser
     * @return
     */
    Integer batchInsertUsers(List<UserDto> listUser);

}
