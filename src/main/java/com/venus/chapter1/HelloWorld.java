package com.venus.chapter1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller
 *
 * @author Alan Liu
 * @create 2016-11-25 13:47
 **/

@Controller
public class HelloWorld {

    @RequestMapping("/helloworld")
    @ResponseBody
    public String helloWorld(){
        return "Hello World!";
    }
}
