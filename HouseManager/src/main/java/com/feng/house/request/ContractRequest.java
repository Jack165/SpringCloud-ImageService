package com.feng.house.request;

import java.util.List;

import com.feng.house.entity.Contract;
import com.feng.house.entity.Cost;
import com.feng.house.entity.UserInfo;

import lombok.Data;

@Data
public class ContractRequest {

	public UserInfo renter;
	
	public Contract contract;
	
	public List<Cost> costList;
	
}
