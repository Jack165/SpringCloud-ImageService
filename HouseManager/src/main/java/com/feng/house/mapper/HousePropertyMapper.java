package com.feng.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.house.entity.HouseProperty;

public interface HousePropertyMapper extends BaseMapper<HouseProperty>{
	
	@Select("select * from house_property  where status !=4  and homeowners_id = ${homeOwnerId} ")
	public List<HouseProperty> selectHoustByUserId(@Param("homeOwnerId") Integer userId);
	
	@Select("select * from house_property  where status =${status} and homeowners_id = ${homeOwnerId} order by update_time")
	public List<HouseProperty> selectHoustByStatus(@Param("status") Integer status,@Param("homeOwnerId") Integer homeOwnerId);
	
	@Select("select * from house_property  where status =${status}  order by update_time")
	public List<HouseProperty> selectAllHoustByStatus(@Param("status") Integer status);

	
	
}
