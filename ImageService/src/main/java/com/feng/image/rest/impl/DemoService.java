package com.feng.image.rest.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.feng.image.DTO.DemoMessage;
import com.feng.image.util.LogUtil;
import com.feng.image.util.OCRUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("测试接口")
@Controller
public class DemoService implements IdemoServices {
	Logger apmInfoLogger = LoggerFactory.getLogger("APMInfoDev");

	@ApiOperation(value = "测试信息", notes = "测试")
	@PostMapping("/test/info")
	@ResponseBody
	public String getInfo() {
		JSONObject j = JSONObject.parseObject("{'b':'2'}");
		LogUtil.info("getInfo", j.toJSONString());
		return "info";

	}

	@ApiOperation(value = "测试信息", notes = "测试", response = DemoMessage.class)
	@RequestMapping("/test/message")
	@ResponseBody
	@Override
	public DemoMessage getMessage(String name) {
		DemoMessage message = new DemoMessage();
		message.code = 0;
		message.message = name + "来自服务端端尾巴！";
		return message;
	}

	@ApiOperation(value = "测试信息", notes = "测试", response = DemoMessage.class)
	@RequestMapping("/ocr")
	@ResponseBody
	@Override
	public String upload(MultipartFile file) {
		if (file.isEmpty()) {
			return "文件是空";
		}
		String text = "识别异常";
		try {
			text = OCRUtil.getOcrText(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}

}
