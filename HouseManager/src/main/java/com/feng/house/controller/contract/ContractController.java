package com.feng.house.controller.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.house.entity.UserInfo;
import com.feng.house.manager.ContractManager;
import com.feng.house.mapper.ContractMapper;
import com.feng.house.mapper.CostMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.BillReq;
import com.feng.house.request.ContractRequest;
import com.feng.house.response.ContractListRes;
import com.feng.house.response.Response;
import com.feng.house.util.AopMethod;

@Controller
@RequestMapping("/contract")
public class ContractController {
	

	@Autowired
	ContractManager contractManager;
	
	@RequestMapping("/add")
	@ResponseBody
	@AopMethod(title="添加合同")
	public Response addContract(@RequestBody ContractRequest request) {
		
		
		contractManager.addControct(request);
		
		
		return Response.resultmsg("添加成功", 200);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@AopMethod(title="合同列表")
	public Response getControct(@RequestBody BillReq request ) {
		
		List<ContractListRes> result=contractManager.getContralistByowner(request.getUserId());
		
		return Response.resultObject(result, 200);
	}
	
	@RequestMapping("/list/renter")
	@ResponseBody
	@AopMethod(title = "根据房客查询合同")
	public Response getControctByRenter(@RequestBody BillReq request ) {
		
		List<ContractListRes> result=contractManager.getContralistRenter(request.getUserId());
		
		return Response.resultObject(result, 200);
	}
	
	@RequestMapping("/select")
	@ResponseBody
	@AopMethod(title = "查询合同")
	public ContractRequest getContract(@RequestBody BillReq request) {
		ContractRequest result=contractManager.getContract(request.getId());
		return result;
		
	}

}
