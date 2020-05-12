package com.feng.image.util;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class LogUtil {


	 
	
	
	 static Logger log = LoggerFactory.getILoggerFactory().getLogger("fslog");
	 
	 private static HashMap<String, Object> buildLogCommenParamsMap(String message){
		 HashMap<String, Object> result=new HashMap<>();
		 java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		 result.put("message", message);
		 LocalDateTime localDate=LocalDateTime.now();
		 result.put("log_timestamp", localDate.format(formatter));
		 return result;
	 }
	
	 public static void info(String name,String messsage) {
		 HashMap<String, Object> params=buildLogCommenParamsMap(messsage);
		 params.put("method_name", name);
		 log.info(JSON.toJSONString(params));
		
	}
}
