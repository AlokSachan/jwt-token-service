package com.alok.jwttokenservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author asachan@app-scoop.com
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/demo")
    public String demo() {
        return "Welcome to JWT Demo";
    }

}
