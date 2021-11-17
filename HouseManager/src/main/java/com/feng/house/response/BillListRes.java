package com.feng.house.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillListRes {

	private int id;
	private String name;
	private String money;
	private String state;
}
