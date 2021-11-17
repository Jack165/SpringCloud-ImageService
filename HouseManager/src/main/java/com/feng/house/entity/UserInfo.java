package com.feng.house.entity;



import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor 
public class UserInfo {
	 @TableId(type = IdType.AUTO)
	private Integer id;
    private String name;
    private String account;
    private String sex;
    private String idCard;
    private String cellPhone;
    private int status;
}
