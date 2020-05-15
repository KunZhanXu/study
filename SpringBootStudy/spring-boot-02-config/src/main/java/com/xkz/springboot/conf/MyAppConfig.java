package com.xkz.springboot.conf;

import com.xkz.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类：就是来替代之前的spring文件
 *
 * 在配置文件用<bean></bean>标签添加组件
 */
@Configuration
public class MyAppConfig {

    //将方法返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
