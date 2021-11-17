package com.feng.house.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.house.entity.Login;

public interface LoginMapper extends BaseMapper<Login>{
	

	@Update("update login set password=${newPwd} where userId=${userId}")
	int updatePassword(@Param("newPwd") String newPwd,@Param("userId") Integer userId);
	
	
	@Select("select * from login where user_id=${userId} and password= ${pwd}")
	Login checkUser(@Param("pwd") String newPwd,@Param("userId") Integer userId);
	
}
