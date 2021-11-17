package com.feng.house.entity;

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
public class Cost {
	 @TableId(type = IdType.AUTO)
	private Integer id;
	private String groupId;
	private String costName;
	private String price;
	private String unit;
	private String initData;
}
