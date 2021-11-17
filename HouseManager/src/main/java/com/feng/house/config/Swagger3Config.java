package com.feng.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.feng.house.plug.ImportBeanDefinitionRegis;
import com.feng.house.plug.LogScan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger3Config {
	 @Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.OAS_30)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.feng.house.controller"))
	                //.apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Swagger3接口文档")
	                .description("更多请咨询服务开发者feng")
	                .contact(new Contact("feng。", "https://www.fetxingtianxia.cn", "1652314522@qq.com"))
	                .version("1.0")
	                .build();
	    }
}
