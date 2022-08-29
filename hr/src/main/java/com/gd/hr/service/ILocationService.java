package com.gd.hr.service;

import java.util.Map;

import org.springframework.stereotype.Service;


import com.gd.hr.vo.Location;


@Service
public interface ILocationService {
	
	// Location 추가
	public int addLocationForm(Location location);
	
	// RegionList 불러오기
	public Map<String, Object> addLocationForm();

	
}
