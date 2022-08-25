package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper
public interface RegionMapper {
	
	// 기본 CRUD
	List<Region> selectRegionList();
	int insertRegion(Region reigon);	
	Region selectRegionOne(int regionId); // 수정 폼
	int updateRegion(Region reigon); // 수정액션
	int deleteRegion(int regionId);

}
