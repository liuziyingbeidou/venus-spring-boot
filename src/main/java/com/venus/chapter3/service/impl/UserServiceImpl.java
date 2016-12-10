package com.venus.chapter3.service.impl;

import com.venus.chapter3.dto.UserDto;
import com.venus.chapter3.service.UserService;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
        Integer count = jdbcTemplate.update("delete from vns_user where u_name = ?", name);
        System.out.print("delete :"+count);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from vns_user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from vns_user");
    }

    @Override
    public List<UserDto> queryUsers() {
        RowMapper<UserDto> rm = BeanPropertyRowMapper.newInstance(UserDto.class);
        List<UserDto> userList = jdbcTemplate.query("select * from vns_user",rm);
        userList = jdbcTemplate.queryForList("select * from vns_user",UserDto.class);
        return userList;
    }

    @Override
    public UserDto queryUserByName(String name) {
        RowMapper<UserDto> rm = BeanPropertyRowMapper.newInstance(UserDto.class);
        UserDto userDto = (UserDto) jdbcTemplate.queryForObject("select * from vns_user where u_name = ?",rm,name);
        return userDto;
    }

    @Override
    @Transactional
    public Integer batchInsertUsers(List<UserDto> listUser) {
        String sql = "insert vns_user(u_code,u_name,u_age) values(?,?,?)";
        jdbcTemplate.batchUpdate(sql,setParameters(listUser));
        /*jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter()
        {
            public void setValues(PreparedStatement ps, int i)throws SQLException
            {
                String code = listUser.get(i).getuCode();
                String name=listUser.get(i).getuName();
                int age=listUser.get(i).getuAge();
                ps.setString(1,code);
                ps.setString(2, name);
                ps.setInt(3, age);
            }
            public int getBatchSize()
            {
                return listUser.size();
            }
        });*/
        return 0;
    }

    /**
     * 设置参预置数
     * @param listUser
     * @return
     */
    private List<Object[]> setParameters(List<UserDto> listUser){
        List<Object[]> parameters = new ArrayList<Object[]>();
        for (UserDto u : listUser) {
            parameters.add(new Object[] { u.getuCode(),u.getuName(),u.getuAge()});
        }
        return parameters;
    }
}
