package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

@Controller
public class RegionController {
	@Autowired IRegionService regionService;
	
	@GetMapping("/regionList")
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		model.addAttribute("list",list);
		return "regionList";
	}
	
	@GetMapping("/addRegion")
	public String addRegion(){
		return "addRegion";
	}
	
	@PostMapping("/addRegion")
	public String addRegion(Region region) {
		// 디버깅
		System.out.println(region);
		int row = regionService.addRegion(region);
		// 디버깅
		System.out.println(row);
		return "redirect:/regionList"; // regionList redirect
	}

	@GetMapping("/removeRegion")
	public String removeRegion(int regionId){
		// 디버깅
		System.out.println(regionId);
		int row= regionService.removeRegion(regionId);
		// 디버깅
		System.out.println(row);
		return "redirect:/regionList";
	}
	
	
	
}
