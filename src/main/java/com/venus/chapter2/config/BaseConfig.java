package com.venus.chapter2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义参数注入
 * @author Alan Liu
 * Created by on 2016/11/26 0026.
 */
@Component
public class BaseConfig {

    @Value("${com.venus.config.project.name:Test}")
    private String name;
    @Value("${com.venus.config.project.version}")
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
