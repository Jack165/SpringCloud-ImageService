package com.feng.image.rest.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.image.DTO.DemoMessage;

import io.swagger.annotations.ApiOperation;

@Controller
public interface IdemoServices {
	
	  @ApiOperation(value = "测试信息" ,  notes="测试",response = DemoMessage.class)  
	  @RequestMapping("/test/message")
	  @ResponseBody
	public DemoMessage getMessage( String name);

}
