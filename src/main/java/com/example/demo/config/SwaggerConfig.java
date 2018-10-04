package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("JPub Spring Boot")
                .description("Spring Boot Rest API")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // .groupName("basic")
                // .groupName("users")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build()
                .apiInfo(metadata());
    }
}
