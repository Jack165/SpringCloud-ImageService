package com.feng.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.house.entity.BillDetail;

public interface BillDetailMapper extends BaseMapper<BillDetail>{
	
	@Select("select * from bill_detail where tenant_id=#{tenantId}")
	List<BillDetail> getRentanBill(@Param("tenantId") Integer tenantId);
	
	@Select("select * from bill_detail where homeowners_id=#{ownerUserId}  and status=${status}")
	List<BillDetail> getBillByStatus(@Param("ownerUserId") Integer  ownerUserId,@Param("status") Integer status);
	
	@Select("select * from bill_detail where homeowners_id=#{ownerUserId} and status !=0 ")
	List<BillDetail> getAllBillByOwner(@Param("ownerUserId") Integer  ownerUserId);
	
	@Select("select * from bill_detail where tenant like  '%${tenant}%' and status !=0 ")
	List<BillDetail> getAllBillByTenantName(@Param("tenant") String  tenant);


}
