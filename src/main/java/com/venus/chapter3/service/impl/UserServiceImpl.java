package com.venus.chapter3.service.impl;

import com.venus.chapter3.dto.UserDto;
import com.venus.chapter3.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户接口实现类
 * Created by Alan Liu on 2016/12/2 0002.
 */
@Service
public class UserServiceImpl implements UserService {

    //JdbcTemplate注入实例
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(UserDto userDto) {
        jdbcTemplate.update("insert into vns_user(u_name, u_age) values(?, ?)", userDto.getuName(), userDto.getuAge());
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from vns_user where u_name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from vns_user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from vns_user");
    }
}
