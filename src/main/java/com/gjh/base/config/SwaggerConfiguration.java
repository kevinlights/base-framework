package com.gjh.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:04
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${app.swagger.basePackage}")
    private String basePackage;

    @Value("${app.swagger.title}")
    private String title;

    @Value("${app.swagger.description}")
    private String description;

    @Value("${app.swagger.serviceUrl}")
    private String serviceUrl;

    @Value("${app.swagger.contact}")
    private String contact;

    @Value("${app.swagger.version}")
    private String version;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(serviceUrl)
                .contact(contact)
                .version(version)
                .build();
    }
}
