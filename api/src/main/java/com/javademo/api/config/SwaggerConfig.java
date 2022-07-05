package com.javademo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("JWT").build()))
                .securityContexts(Collections.singletonList(getSecurityContext())
                )
                .enable(true)
                .groupName("JAVA")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javademo.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private SecurityContext getSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(
                                SecurityReference.builder().scopes(new AuthorizationScope[0]).reference("JWT").build()
                                )
                )
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "JAVA_DEMO API",
                "",
                "V1.0",
                "https://github.com/Yanshaoshuai/JAVA_DEMO",
                new Contact("Shaoshuai-Yan", "https://yanshaoshuai.github.io/", "ahutyss@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
