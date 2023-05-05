package com.dex.hellowo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Watson!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable("name") String name) {
        return String.format("Hello, %s!", name);
    }
}
