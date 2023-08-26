package com.cyr.springboot.configure;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig  implements WebMvcConfigurer{

	@Bean
	public Docket postsApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
		 .select()
         .apis(RequestHandlerSelectors.basePackage("com.cyr.springboot.controller"))
         .paths(regex("/api.*"))
         .build()
         .apiInfo(metaInfo());
	}

	 private ApiInfo metaInfo() {

	        ApiInfo apiInfo = new ApiInfo(
	                "EMPLOYEE CRUD with SWAGGER2",
	                "using API REST in springboot.",
	                "java 1.8",
	                "Terms of Service",
	                new Contact("ramana", "www.google.com",
	                        "EEE"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
	        );

	        return apiInfo;
	    }
    }
