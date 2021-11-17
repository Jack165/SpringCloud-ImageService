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
public class HouseProperty {
	 @TableId(type = IdType.AUTO)
	private Integer id;
	private String addressDetail;
	private String homeowners;
	private Integer HomeownersId;
	private LocalDateTime updateTime;
	private String estimatePrice;
	private Integer status;

}
