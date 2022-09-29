package com.scii.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2	
public class SwaggerConfig {
	
	@Bean
	public Docket createDocument() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.scii.controller"))
				.paths(PathSelectors.regex("/app.*")).build();
		}
     
		/*
		 * private ApiInfo apiInfo() { return new ApiInfo("J.K Product",
		 * "Product mangaement", "PV 1.0", "http://locahost:9595/product", new
		 * Contact("Jitendra","http://locahost:9595/product","jk@gmail.co"),
		 * "J.K Technology", "http://locahost:9595/product", new
		 * ArrayList<VendorException>()); //ApiInfo("J.K Product", "Product mangaement",
		 * "PV 1.0", "http://locahost:9595/product", new
		 * Contact("Jitendra","http://locahost:9595/product","jk@gmail.co"),
		 * "J.K Technology","http://locahost:9595/product", new
		 * ArrayList<VendorException>());
		 * 
		 * 
		 * //ApiInfo("J.K Product", "Product mangaement", "PV 1.0",
		 * "http://locahost:9595/product", new
		 * Contact("Jitendra","http://locahost:9595/product","jk@gmail.co"),
		 * "J.K Technology","http://locahost:9595/product", new
		 * ArrayList<VendorException>()); }
		 */
}
