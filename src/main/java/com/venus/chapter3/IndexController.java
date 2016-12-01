package com.venus.chapter3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Jsp页面访问
 * Created by Alan Liu on 2016/12/1 0001.
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("hello", "http://blog.didispace.com");
        return "index";
    }
}
