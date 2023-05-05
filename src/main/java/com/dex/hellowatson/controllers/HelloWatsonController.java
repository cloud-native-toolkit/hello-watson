package com.dex.hellowatson.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWatsonController {

    @GetMapping("/hello")
    @Operation(summary = "Say hello to Watson")
    public String hello() {
        return "Hello, Watson!";
    }

    @GetMapping("/hello/{name}")
    @Operation(summary = "Say hello to someone")
    public String helloName(@PathVariable("name") String name) {
        return String.format("Hello, %s!", name);
    }
}
