package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

// 내 서비스만 오는게 좋음
@Controller
public class CountryController {
	@Autowired ICountryService countryService;

	// 나라 추가 Form
	// RegionList 불러오기  
	@GetMapping("/addCountry")
	public String addCountry(Model model) {
		List<Region> regionList = countryService.addCountryForm();
		// 디버깅
		System.out.println(regionList);
		model.addAttribute("regionList", regionList);
		return "addCountry"; // <select><c:foreach var="region" items="${regionList}"><option>....
	}

	// 나라 추가 Action	
	@PostMapping("/addCountry")
	public String addCountry(Country country) {
		int row = countryService.addCountry(country);
		// 디버깅
		System.out.println(row);
		return "redirect:/countryList";
	}
	
	// 나라 리스트
	@GetMapping("/countryList")
	public String countryList(Model model) {
		List<Map<String, Object>> countryList = countryService.getCountry();
		// 디버깅
		System.out.println(countryList);
		model.addAttribute("countryList", countryList);
		return "countryList";
	}

	// 나라 수정 Form
	@GetMapping("/modifyCountry")
	public String modifyCountry(Model model, @RequestParam("countryId") String countryId) {
		Country countryList = countryService.getCountryOne(countryId);
		model.addAttribute("countryList",countryList);
		return "modifyCountry";
	}
	// 나라 수정 Action
	@PostMapping("/modifyCountry")
	public String modifyList(Country country) {
		// 디버깅
		System.out.println(country);
		int row = countryService.modifyCountry(country);
		// 디버깅
		System.out.println("row");
		
		return "redirect:/countryList";
	}

	// 나라 삭제
	@GetMapping("/removeCountry")
	public String removeCountry(String countryId) {
		int row = countryService.removeCountry(countryId);
		// 디버깅
		System.out.println("row");
		return "removeCountry";
	}
}