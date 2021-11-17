package com.feng.house.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
public class Login {
	 @TableId(type = IdType.AUTO)
private Integer id;
private String account;
private Integer userId;
private String userName;
private String password;
}
