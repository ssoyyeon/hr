package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;
import com.gd.hr.mapper.ICountryMapper;
import com.gd.hr.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 어떠한 Mapper가 와도 상관없음.
@Service
@Transactional
public class CountryService implements ICountryService {   
   @Autowired RegionMapper regionMapper;
   @Autowired ICountryMapper countryMapper;
   
    // CountryList 가져오기
	@Override
	public List<Country> getCountryIdAndList(int regionId) {
		List<Country> list = countryMapper.selectCountryIdAndList(regionId);
		return list;
	}
   
   // RegionList 가져오기
   @Override
   public List<Region> addCountryForm() {
      List<Region> regionList = regionMapper.selectRegionList();
      return regionList;
   }
   
   // 나라 추가
   @Override
   public int addCountry(Country country) {
		return countryMapper.insertCountry(country);
   }
   
   // 나라 리스트
   @Override
   public List<Map<String, Object>> getCountry() {
	   return countryMapper.selectCountryList();
   }
	
   // 나라 수정 폼
   @Override
	public Country getCountryOne(String countryId) {
		return countryMapper.selectCountryOne(countryId);
	}
   // 나라 수정 액션
	@Override
	public int modifyCountry(Country country) {
		return countryMapper.updateCountry(country);
	}
	
	// 나라 삭제
	@Override
	public int removeCountry(String countryId) {
		return countryMapper.deleteCountry(countryId);
	}



	
}