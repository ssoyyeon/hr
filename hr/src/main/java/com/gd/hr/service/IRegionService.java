package com.gd.hr.service;

import java.util.List;

import com.gd.hr.vo.Region;

public interface IRegionService {
	// regions 테이블 select 메서드를 호출하는 interface의 메서드
	List<Region> getRegionList();
	Region getRegion(int regionId);
	// regions 테이블 insert 메서드를 호출하는 interface의 메서드
	int addRegion(Region region);
	// regions 테이블 update 메서드를 호출하는 interface의 메서드
	int modifyRegion(Region region);
	// regions 테이블 delete 메서드를 호출하는 interface의 메서드
	int removeRegion(int regionId);
}
