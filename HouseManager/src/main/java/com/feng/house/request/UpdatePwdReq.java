package com.feng.house.request;

import lombok.Data;

@Data
public class UpdatePwdReq {
	private Integer userId;
	private String oldPwd;
	private String newPwd;
}
