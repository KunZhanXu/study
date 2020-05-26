package com.xkz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {
    @RequestMapping("/quick1")
    public String quick(){
        return "hello aklhdflkaglkashg";
    }
}
