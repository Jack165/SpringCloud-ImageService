package com.feng.house.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractListRes {

	private Integer id;
	private String name;
	private String room;
	private String status;
	
	
}
