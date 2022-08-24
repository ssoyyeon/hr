package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class RegionService implements IRegionService {
	@Autowired RegionMapper regionMapper;
	
	@Override
	public List<Region> getRegionList() {
		return regionMapper.selectRegionList();
	}

	@Override
	public int addRegion(Region region) {
		return regionMapper.insertRegion(region);
	}

	@Override
	public int removeRegion(int regionId) {
		
		return regionMapper.deleteRegion(regionId);
	}

}
