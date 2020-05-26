package com.xkz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

@RestController
public class Quick2Controller {

    @Value("${name}")
    private String name;

    @RequestMapping("/quick2")
    public String quick2(){
        return "name:"+ name;
    }

}
