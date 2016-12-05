package com.venus.chapter3.controller;

import com.venus.chapter3.dto.UserDto;
import com.venus.chapter3.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alan Liu on 2016/12/2 0002.
 */

@Controller
@RequestMapping("/venus/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "userDto", value = "用户详细实体user", required = true, dataType = "UserDto")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestBody UserDto userDto){
        userService.create(userDto);
        return "success";
    }

    @ApiOperation(value="获取用户数", notes="")
    @RequestMapping(value={"/getUserCount"}, method=RequestMethod.GET)
    @ResponseBody
    public Integer getUserCount() {
        Integer userCount = userService.getAllUsers();
        return userCount;
    }

    @ApiOperation(value="根据用户名删除用户", notes="")
    @RequestMapping(value={"/deleteByName"}, method=RequestMethod.GET)
    @ResponseBody
    public String deleteByName(@RequestBody String uName) {
        userService.deleteByName(uName);
        return "Success";
    }

    @ApiOperation(value="查询所有用户", notes="")
    @RequestMapping(value={"/getUserList"}, method=RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getUserList() {
        return userService.queryUsers();
    }

    @ApiOperation(value="根据用户名查询用户", notes="")
    @RequestMapping(value={"/getUserByName"}, method=RequestMethod.POST)
    @ResponseBody
    public UserDto getUserByName(@RequestBody String uName) {
        return userService.queryUserByName(uName);
    }
}
