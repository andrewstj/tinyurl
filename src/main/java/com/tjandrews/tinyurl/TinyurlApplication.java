package com.tjandrews.tinyurl;

import com.fasterxml.classmate.TypeResolver;
import com.tjandrews.tinyurl.business.models.UrlMappingRequest;
import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TinyurlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyurlApplication.class, args);
	}

	@Bean
	public Docket apiDocket(TypeResolver typeResolver) {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tjandrews.tinyurl")).build()
				.additionalModels(typeResolver.resolve(UrlMapping.class), typeResolver.resolve(UrlMappingRequest.class));
	}

}
