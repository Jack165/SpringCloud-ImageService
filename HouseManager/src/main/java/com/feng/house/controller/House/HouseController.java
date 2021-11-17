package com.feng.house.controller.House;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.feng.house.entity.BillDetail;
import com.feng.house.entity.HouseProperty;
import com.feng.house.entity.UserInfo;
import com.feng.house.enums.HouseState;
import com.feng.house.mapper.BillDetailMapper;
import com.feng.house.mapper.HousePropertyMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.BillReq;
import com.feng.house.request.HouseReq;
import com.feng.house.response.HouseRes;
import com.feng.house.response.Response;
import com.feng.house.util.AopMethod;

@Controller
@RequestMapping("/house")
public class HouseController {

	@Autowired
	HousePropertyMapper housePropertyMapper;

	@RequestMapping("/list")
	@ResponseBody
	@AopMethod(title = "房产查询")
	public Response getHouseList(@RequestBody BillReq request) {

		List<HouseRes> result=new ArrayList<>();
		HouseProperty hp=new HouseProperty();
		hp.setHomeownersId(request.getUserId());
		List<HouseProperty> houseList=new ArrayList<>();
		if(null!=request.getStatus()&&request.getStatus()!=0) {
			houseList=housePropertyMapper.selectHoustByStatus(request.getStatus(),request.getUserId());

		}else {
			houseList=housePropertyMapper.selectHoustByUserId(request.getUserId());
		}
		
		
		for(HouseProperty houseProperty:houseList) {
			HouseRes res=new HouseRes();
			BeanUtils.copyProperties(houseProperty, res);
			res.setStatus(HouseState.getDescByid(houseProperty.getStatus()));
			result.add(res);
		}
		return Response.successResultObject(result);
	}
	
	@RequestMapping("add")
	@ResponseBody
	@AopMethod(title="添加房产")
	public Response addHouse(@RequestBody HouseReq houseReq) {
		
		HouseProperty houseProperty =new HouseProperty();
		BeanUtils.copyProperties(houseReq, houseProperty);
		 int res=housePropertyMapper.insert(houseProperty);
		if(res>0) {
			return Response.resultmsg(Response.SUCCESS_MSG,Response.srccess);
		}else {
			return Response.resultmsg(Response.FAIL_MSG, Response.fail);
		}
	}
	

}
