package com.imhere.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloImHere {

    @RequestMapping("/")
    public String hello() {
        return "Welcome to ImHere!!";
    }

}