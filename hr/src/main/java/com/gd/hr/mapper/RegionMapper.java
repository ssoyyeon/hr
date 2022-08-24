package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper
public interface RegionMapper {
	List<Region> selectRegionList();
	int insertRegion(Region reigon);
	int deleteRegion(int regionId);
}
