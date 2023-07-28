package com.ctrenka.spring_mongodb_mysql_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final static AtomicLong counter = new AtomicLong();
    private String template = "Hello, %s";
    @GetMapping("/")
    public String Index(@RequestParam(value = "name", defaultValue = "world")String name) {
        return String.format(template, name);
    }
}
