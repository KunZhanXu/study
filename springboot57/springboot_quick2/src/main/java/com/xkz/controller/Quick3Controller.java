package com.xkz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "person")
public class Quick3Controller {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @RequestMapping("/quick3")
    public String quick2(){
        return "name:"+ name;
    }

}
