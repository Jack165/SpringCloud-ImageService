package com.feng.house.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HouseRes {
	private Integer id;
	private String addressDetail;
	private String homeowners;
	private Integer HomeownersId;
	private LocalDateTime updateTime;
	private String estimatePrice;
	private String status;
}
