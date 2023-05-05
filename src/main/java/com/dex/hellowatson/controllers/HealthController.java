package com.dex.hellowatson.controllers;

import com.dex.hellowatson.models.SimpleResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@CrossOrigin()
public class HealthController {

    @GetMapping(value = "/health", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Simple health response")
    public SimpleResponse<String> health() {
        return new SimpleResponse<>("OK");
    }
}
