package com.feng.house.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feng.house.log.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.house.entity.BillDetail;
import com.feng.house.entity.HouseProperty;
import com.feng.house.entity.Login;
import com.feng.house.entity.UserInfo;
import com.feng.house.enums.BillState;
import com.feng.house.enums.HouseState;
import com.feng.house.log.LogService;
import com.feng.house.mapper.BillDetailMapper;
import com.feng.house.mapper.HousePropertyMapper;
import com.feng.house.mapper.LoginMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.BillReq;
import com.feng.house.request.LoginReq;
import com.feng.house.response.IndexRes;
import com.feng.house.response.RecommendRes;
import com.feng.house.response.Response;
import com.feng.house.response.UserRes;
import com.feng.house.util.JsonUtil;
import com.feng.house.util.AopMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/index")
@Api
public class indexController {
	
	@Autowired
	BillDetailMapper billDetailMapper;
	
	@Autowired
	HousePropertyMapper housePropertyMapper;
	
	@Autowired
	LoginMapper loginMapper;


	//@Autowired
	//LogManager logManager;

	@RequestMapping("/get_index")
	@ResponseBody
	@AopMethod
	public Response getIndex(@RequestBody BillReq request) {

		//logManager.showLog();
		
		 IndexRes result=new IndexRes();
		 List<HouseProperty>  houseProperties=housePropertyMapper.selectHoustByUserId(request.getUserId());
		 result.setHouseNum(houseProperties.size());
		 List<BillDetail> noHavebillDetails= billDetailMapper.getBillByStatus(request.getUserId(),BillState.NO_HAVE.id);
		 result.setWaitIn(noHavebillDetails.size());
		 List<BillDetail> havebillDetails= billDetailMapper.getBillByStatus(request.getUserId(),BillState.HAVE.id);
		 result.setReceived(havebillDetails.size());
		 return Response.successResultObject(result);
	}
	
	@RequestMapping("/get_recommend")
	@ResponseBody
	@AopMethod(title="推荐")
	public Response getRecommend() {
		List<HouseProperty> houseList= housePropertyMapper.selectAllHoustByStatus(HouseState.FREE.id);
	    List<RecommendRes> result=new ArrayList<>();
	
		if(houseList.size()>3) {
			houseList=houseList.subList(0, 3);
		}
		for(HouseProperty house:houseList) {
			RecommendRes r=new RecommendRes();
			r.setAddressDetail(house.getAddressDetail());
			r.setHomeowners(house.getHomeowners());
			r.setId(house.getId());
			r.setUpdateTime(house.getUpdateTime());
			result.add(r);
		}
		return Response.successResultObject(result);
	}
	
	
}
