package com.venus.chapter3;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Jsp页面访问
 * Created by Alan Liu on 2016/12/1 0001.
 */
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("hello","JSP页面访问！");
        return"index";
    }
}
