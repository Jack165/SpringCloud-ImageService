package com.feng.house.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HouseReq {
	private String addressDetail;
	private String homeowners;
	private Integer HomeownersId;
	private LocalDateTime updateTime;
	private String estimatePrice;
	private Integer status;
}
