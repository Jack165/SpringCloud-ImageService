package com.feng.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.feng.house.plug.ImportBeanDefinitionRegis;
import com.feng.house.plug.LogScan;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan("com.feng.house.mapper")
@LogScan("com.feng.house.log")
@Import(ImportBeanDefinitionRegis.class)
public class HouseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseManagerApplication.class, args);
	}

}
