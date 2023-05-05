package com.dex.hellowatson.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HealthController {

    @GetMapping("/health")
    @Operation(summary = "Simple health response")
    public String health() {
        return "OK";
    }
}
