package com.imhere.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.imhere.controller"})
public class ImHereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImHereApplication.class, args);

        System.out.println("Started ImHere Application:");
    }

}