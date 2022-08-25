package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

@Controller
public class RegionController {
	@Autowired IRegionService regionService;
	
	
	// select 
	@GetMapping("/regionList")
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		// 디버깅
		System.out.println("regionList list : " + list);
		model.addAttribute("list",list);
		return "regionList";
	}
	
	// insert
	@GetMapping("/addRegion")
	public String addRegion(){
		return "addRegion";
	}
	
	@PostMapping("/addRegion")
	public String addRegion(Region region) {
		// 디버깅
		System.out.println("addRegion : " + region);
		int row = regionService.addRegion(region);
		// 디버깅
		System.out.println("addRegion : " + row);
		return "redirect:/regionList"; // regionList redirect
	}
	
	// update Form
	@GetMapping("/modifyRegion")
	public String modifyRegion(Model model, @RequestParam(value="regionId") int regionId) { // @RequestParam(가져올 테이터 이름)데이터타입, 가져온 데이터를 담을 변수
		Region region = regionService.getRegion(regionId);
		// 디버깅
		System.out.println("modifyRegion  update Form region :" + region);
		model.addAttribute("region",region);
		return "modifyRegion";	
	}
	// update Action
	@PostMapping("/modifyRegion")
	public String modifyRegion(Region region) {
		// 디버깅
		System.out.println("modifyRegion update Action region :" + region);
		int row = regionService.modifyRegion(region);
		// 디버깅
		System.out.println("modifyRegion update Action row :" + row);
		return "redirect:/regionList";
	}

	// delete
	@GetMapping("/removeRegion")
	public String removeRegion(int regionId){
		// 디버깅
		System.out.println(regionId);
		int row= regionService.removeRegion(regionId);
		// 디버깅
		System.out.println("removeRegion row" + row);
		return "redirect:/regionList";
	}
	
	
	
}
