package com.feng.image.rest.impl;

import org.springframework.web.bind.annotation.PostMapping;

import com.feng.image.DTO.DemoMessage;

import io.swagger.annotations.ApiOperation;

public interface IdemoServices {
	
	  @ApiOperation(value = "测试信息" ,  notes="测试",response = DemoMessage.class)  
	    @PostMapping("/test/message")
	public DemoMessage getMessage(String name);

}
