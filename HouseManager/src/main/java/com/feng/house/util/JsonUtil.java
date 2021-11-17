package com.feng.house.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static Gson gson=new GsonBuilder().setPrettyPrinting().create();
	
	
	public static String toString(Object obj) {
		
	        return gson.toJson(obj);
	}
	
	public static <T> T toObject(String str,Class<T> cls) {
		if(null!=str&&!str.trim().equals("")) {
			return gson.fromJson(str, cls);
		}else {
			return null;
		}
	
	}
	
	
}
