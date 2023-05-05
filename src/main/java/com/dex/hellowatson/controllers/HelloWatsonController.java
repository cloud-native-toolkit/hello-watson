package com.dex.hellowatson.controllers;

import com.dex.hellowatson.models.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWatsonController {

    @GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Say hello to Watson")
    public SimpleResponse<String> hello() {
        return new SimpleResponse<>("Hello, Watson!");
    }

    @GetMapping(value = "/hello/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Say hello to someone")
    public SimpleResponse<String> helloName(@PathVariable("name") String name) {
        return new SimpleResponse<>(String.format("Hello, %s!", name));
    }
}
