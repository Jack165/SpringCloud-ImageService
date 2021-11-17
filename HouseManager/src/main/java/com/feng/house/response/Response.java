package com.feng.house.response;

public class Response {
	

	public static final String SUCCESS_MSG="操作成功";
	public static final String FAIL_MSG="失败";
	public static final int srccess=200;
	public static final int fail=100;

	public int code;
	
	public String msg;
	
	public Object data;
	
	public static Response resultObject(Object o,int code) {
		Response response=new Response();
		response.data=o;
		response.code=code;
		return response;
	}
	
	public static Response resultmsg(String msg,int code) {
		Response response=new Response();
		response.msg=msg;
		response.code=code;
		return response;
	}
	
	public static Response resultSuccess() {
		Response response=new Response();
		response.msg=SUCCESS_MSG;
		response.code=srccess;
		return response;
	}
	
	public static Response resultFail() {
		Response response=new Response();
		response.msg=FAIL_MSG;
		response.code=fail;
		return response;
	}
	
	public static Response successResultObject(Object o) {
		Response response=new Response();
		response.data=o;
		response.msg=SUCCESS_MSG;
		response.code=srccess;
		return response;
	}
}
