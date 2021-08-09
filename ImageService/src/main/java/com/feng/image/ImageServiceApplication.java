package com.feng.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

import com.feng.image.util.LogUtil;


/**
 * @author feng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAsync
public class ImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceApplication.class, args);
		LogUtil.info("main","imageserver启动");
	}

}
