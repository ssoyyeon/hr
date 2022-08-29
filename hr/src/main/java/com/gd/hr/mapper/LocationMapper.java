package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Location;

@Mapper
public interface LocationMapper {
	
	// Location 추가 
	int insertLocation(Location location);
}
