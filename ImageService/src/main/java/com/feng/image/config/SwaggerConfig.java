package com.feng.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(apiInfo())
	        		.select()
	        		.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
	        		.paths(PathSelectors.any())
	        		.build();
	    }
	 
	 
	 private ApiInfo apiInfo() {
		 return new ApiInfoBuilder().title("server").description("图片处理服务").version("1.0").build();
		 
	 }
}
