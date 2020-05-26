package com.xkz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickController {
    @RequestMapping("/quick")
    @ResponseBody
    public String hello(){
        System.out.println("skjhfakshgkshgioasgihasdg");
        return "hello world11111222222222222";
    }
}
