package com.feng.image.DTO;


public class DemoMessage {
	public int code;
	 public String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DemoMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public DemoMessage() {
		super();
	}
	 

}
