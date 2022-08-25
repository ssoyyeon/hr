package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Mapper
public interface ICountryMapper {
	
	// 기본 CRUD
	// RegionList가져오기
	List<Region> addCountryForm();
	
    // 나라 리스트
    List<Map<String,Object>> selectCountryList();
    
    // 나라 추가
    int insertCountry(Country country);
	
	// 나라 수정 Form
    Country selectCountryOne(String countryId);
	// 나라 수정 Action
	int updateCountry(Country country);
    
	// 나라 삭제
	int deleteCountry(String countryId);
}
