package com.gd.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Service
public class LocationService implements ILocationService{
	@Autowired LocationMapper locationMapper;
	@Autowired RegionMapper regionMapper;
	
	// Location 추가
	@Override
	public int addLocationForm(Location location) {
		int row = locationMapper.insertLocation(location);
		return row;
	}
	
	// RegionList 불러오기
	@Override
    public Map<String, Object> addLocationForm() {
      Map<String,Object> resultMap = new HashMap<>();
      List<Region> regionList = regionMapper.selectRegionList();
      resultMap.put("regionList",regionList);
      return resultMap;
    }


	
}
