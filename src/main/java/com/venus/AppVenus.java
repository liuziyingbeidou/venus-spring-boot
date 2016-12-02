package com.venus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot入门之Hello World
 * @author Alan Liu
 * @create 2016-11-25
 * 1.当工程中有@Component, @Service, @Repository, @Controller等，自动注册Spring Beans 需要添加 @ComponentScan
 * 2.@SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan
 * 3.Swagger支持
 */

@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableSwagger2
public class AppVenus
{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
               // .apis(RequestHandlerSelectors.basePackage("com.venus.web"))
                .apis(RequestHandlerSelectors.any())  //对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.csdn.net/liuziyingbeidou")
                .termsOfServiceUrl("http://blog.csdn.net/liuziyingbeidou")
                .contact("Alan Liu")
                .version("1.0")
                .build();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(AppVenus.class,args);
    }
}
