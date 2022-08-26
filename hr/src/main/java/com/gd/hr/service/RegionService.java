package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.ICountryMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class RegionService implements IRegionService {
	// DI : 객체를 직접 생성하지 않고 스프링 프레임워크를 통해(bean객체) 주입
	// 스프링에서 빈 인스턴스가 생성된 이후 @Autowired를 설정한 메서드가 자동으로 호출되고, 인스턴스가 자동으로 주입
	// Interface 타입을 사용
	@Autowired RegionMapper regionMapper;
	@Autowired ICountryMapper IcountryMapper;
	
	// 나라 리스트
	@Override
	public List<Region> getRegionList() {
		return regionMapper.selectRegionList();
	}

	// 나라 추가
	@Override
	public int addRegion(Region region) {
		return regionMapper.insertRegion(region);
	}


	@Override
	public Region getRegion(int regionId) {
	
		return regionMapper.selectRegionOne(regionId);
	}
	// 나라 수정 액션
	@Override
	public int modifyRegion(Region region) {
		return regionMapper.updateRegion(region);
	}

	// 나라 삭제
	@Override
	public int removeRegion(int regionId) {
		IcountryMapper.deleteCountryByRegionId(regionId);
		int row =regionMapper.deleteRegion(regionId);
		/*
			 try {
			 	Class.forName(""); 
			 } catch ( ClassNotFoundException e) {
			 e.printStackTrace(); 
			 throw new RuntimeException(); // 예외를 발생시키지 않는 예외를 발생시켜 @Transactional을 실행할 수 있도록 해준다.
			  }
		 */
		return row;
	}
	

}
