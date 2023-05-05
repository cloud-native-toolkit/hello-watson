package com.dex.hellowatson.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OpenApiConfiguration {
    @Value("${openapi.id}")
    private String id;
    @Value("${openapi.title}")
    private String title;
    @Value("${openapi.description}")
    private String description;

    private final BuildProperties buildProperties;

    public OpenApiConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI()
                .info(buildOpenApiInfo());
    }

    protected Info buildOpenApiInfo() {
        return new Info()
                .title(title)
                .description(description)
                .version(buildProperties.getVersion())
                .extensions(buildExtensions());
    }

    protected Map<String, Object> buildExtensions() {
        final Map<String, Object> extensions = new HashMap<>();

        extensions.put("x-ibm-annotations", "true");
        extensions.put("x-ibm-skill-type", "imported");
        extensions.put("x-ibm-application-id", id);
        extensions.put("x-ibm-application-name", title);
        extensions.put("x-ibm-application-version", buildProperties.getVersion());

        return extensions;
    }
}
