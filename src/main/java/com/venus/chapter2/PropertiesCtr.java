package com.venus.chapter2;

import com.venus.chapter2.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Boot 配置文件 以及多环境profile配置
 * @author Alan Liu
 * Created  on 2016/11/26 0026.
 */
@Controller
public class PropertiesCtr {

    @Autowired
    BaseConfig baseConfig;

    @RequestMapping("/base-config")
    @ResponseBody
    public String test01(){
        String returnMsg = baseConfig.getName() + ":"+ baseConfig.getVersion();
        return returnMsg;
    }
}
