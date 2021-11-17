package com.feng.house.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BillDeatilRes {
	private int id;
    //账单状态
    private String status;
    //收租日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private  LocalDateTime collectDate;
    //缴费开始日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private  LocalDateTime startChangeDate;
    //缴费结束日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime endChangeDate;
    //应收费用
    private  String receivableCost;
    //住户
    private  String tenant;
    //住户ID
    private  Integer tenantId;
    //租金
    private String rent;
    //押金
    private String deposit;
    //水费
    private  String watterCost;
    //电费
    private String electricCost;
    //物业费
    private  String propertyCost;
    //宽带费
    private String broadbandCost;
}
