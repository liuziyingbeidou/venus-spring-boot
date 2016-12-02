package com.venus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Boot入门之Hello World
 * @author Alan Liu
 * @create 2016-11-25
 * 1.当工程中有@Component, @Service, @Repository, @Controller等，自动注册Spring Beans 需要添加 @ComponentScan
 * 2.@SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan
 */

@SpringBootApplication
public class AppVenus
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppVenus.class,args);
    }
}
