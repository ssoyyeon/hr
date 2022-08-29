package com.gd.hr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.hr.service.LocationService;

@Controller
public class LocationController {
	@Autowired LocationService locationService;
	
	@GetMapping("/addLocation")
	public String addLoction(Model model) {
		Map<String, Object> map = locationService.addLocationForm();
		model.addAttribute("regionList",map.get("regionList"));
		return "addLocation";	
	}
}
