package com.ctrenka.spring_mongodb_mysql_auth.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/api/login")
    public UserCredential Login(@RequestBody UserCredential user) {
        logger.info("this is login console.");
        return user;
    }
}
