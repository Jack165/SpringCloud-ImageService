package com.feng.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.house.entity.Cost;

public interface CostMapper extends BaseMapper<Cost>{

	@Select("select * from cost where group_id = ${groupId}")
	List<Cost> getCostByGroup(@Param("groupId") String  groupId);
}
