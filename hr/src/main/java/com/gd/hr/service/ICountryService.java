package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

import org.springframework.stereotype.Service;

// Service는 어떤 Mapper든 다 호출 할 수 있다.
@Service
public interface ICountryService {
	

	// countryList 불러오기
	List<Country> getCountryIdAndList(int regionId);
	
	// regionList 불러오기
	List<Region> addCountryForm();
	
	// 나라 추가
	int addCountry(Country country);
	
	// 나라 리스트
	List<Map<String, Object>> getCountry();
	
	// 나라 수정 폼
	Country getCountryOne(String countryId);
	
	// 나라 수정 액션
	int modifyCountry(Country country);
	
	// 나라 삭제
	int removeCountry(String countryId);
	
	
}
