package com.example.springbootswagger.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String EXAMPLE_TAG = "ExampleController";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any()) <-- would also load maybe the error-controller
                //.apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger.controllers")) <-- would be a option
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // only classes with @RestController
                // .paths(PathSelectors.any()) <-- loads all including the error-controller
                //.paths(regex("/EXAMPLEURLPATH/.*")) <-- would be a option
                .build()
                // if you want to describe your controllers
                .tags(new Tag(EXAMPLE_TAG, "this controller shows a few documentation examples"));
    }
}