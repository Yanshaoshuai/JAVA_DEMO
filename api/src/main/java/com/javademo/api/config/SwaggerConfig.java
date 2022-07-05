package com.javademo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("JAVA")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javademo.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    public ApiInfo apiInfo(){
        return new ApiInfo(
                "JAVA_DEMO API",
                "",
                "V1.0",
                "https://github.com/Yanshaoshuai/JAVA_DEMO",
                new Contact("Shaoshuai-Yan","https://yanshaoshuai.github.io/","ahutyss@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
