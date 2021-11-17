package com.feng.house.controller.bill;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.feng.house.entity.BillDetail;
import com.feng.house.entity.UserInfo;
import com.feng.house.enums.BillState;
import com.feng.house.mapper.BillDetailMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.BillReq;
import com.feng.house.response.BillDeatilRes;
import com.feng.house.response.BillListRes;
import com.feng.house.response.Response;
import com.feng.house.util.AopMethod;
import com.feng.house.util.JsonUtil;
import com.feng.house.util.LogAop;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/bill")
public class BillController {
	private static final  Logger logger  =  LoggerFactory.getLogger(BillController. class );
	@Autowired
	BillDetailMapper billDetailMapper;

	@RequestMapping("/list")
	@ResponseBody
	@AopMethod(title = "列表")
	public Response getBillList(@RequestBody BillReq request) {
		List<BillDetail> billDetailList;
		if(null!=request.getStatus()&&request.getStatus()!=0) {
			 billDetailList = billDetailMapper.getBillByStatus(request.getUserId(),request.getStatus());
			
		}else {
			
		 billDetailList = billDetailMapper.getAllBillByOwner(request.getUserId());
			
		}
	
		List<BillListRes> result=new ArrayList<>();
		for(BillDetail billDetail:billDetailList) {
			BillListRes res=BillListRes.builder()
					.id(billDetail.getId())
					.name(billDetail.getTenant()+billDetail.getCollectDate().format(DateTimeFormatter.ISO_DATE))
					.money(billDetail.getReceivableCost())
					.state(BillState.getDescByid(billDetail.getStatus()))
					.build();
			result.add(res);
		}

		return Response.successResultObject(result);
	}
	
	
	@RequestMapping("/list/ranter")
	@ResponseBody
	@AopMethod(title = "根据人查详情")
	public Response getBillListRanter(@RequestBody BillReq request) {
		List<BillDetail> billDetailList = billDetailMapper.getRentanBill(request.getUserId());
		List<BillListRes> result=new ArrayList<>();
		for(BillDetail billDetail:billDetailList) {
			BillListRes res=BillListRes.builder()
					.id(billDetail.getId())
					.name(billDetail.getTenant()+billDetail.getCollectDate().format(DateTimeFormatter.ISO_DATE))
					.money(billDetail.getReceivableCost())
					.state(BillState.getDescByid(billDetail.getId()))
					.build();
			result.add(res);
		}

		return Response.successResultObject(result);
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	@AopMethod(title = "明细")
	public Response getBillDetail(@RequestBody BillReq request) {
		BillDetail detail=	billDetailMapper.selectById(request.getId());
		BillDeatilRes result=new BillDeatilRes();
		BeanUtils.copyProperties(detail, result);
		result.setStatus(BillState.getDescByid(detail.getId()));
		return Response.successResultObject(result);
	}

	
	@RequestMapping("/received")
	@ResponseBody
	@AopMethod(title = "确认收款")
	public Response receivedBill(@RequestBody BillReq request) {
		BillDetail detail=	billDetailMapper.selectById(request.getId());
		if(null!=detail) {
			detail.setStatus(BillState.HAVE.id);
			billDetailMapper.updateById(detail);
		}
		return Response.successResultObject("收账成功!");
	}
	
	@RequestMapping("/search")
	@ResponseBody
	@AopMethod(title = "名称搜索")
	public Response search(@RequestBody BillReq request) {
		List<BillListRes> result=new ArrayList<>();
		List<BillDetail> billDetailList =new ArrayList<>();
		try {
			billDetailList = billDetailMapper.getAllBillByTenantName(request.getName());
		
			for(BillDetail billDetail:billDetailList) {
				BillListRes res=BillListRes.builder()
						.id(billDetail.getId())
						.name(billDetail.getTenant()+billDetail.getCollectDate().format(DateTimeFormatter.ISO_DATE))
						.money(billDetail.getReceivableCost())
						.state(BillState.getDescByid(billDetail.getStatus()))
						.build();
				result.add(res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.successResultObject(result);

	}
	
	
}
