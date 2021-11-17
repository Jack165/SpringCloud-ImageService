package com.feng.house.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor                 //无参构造
@AllArgsConstructor 
public class Contract {
	 @TableId(type = IdType.AUTO)
private Integer id;
private Integer renterId;
private String renterName;
private Integer housownerId;
private String houseownerName;
private String contract;
private Integer housePropertyId;
private String housePropertyName;
private String costGroup;
private Integer status;
}
