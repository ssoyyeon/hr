package com.gd.hr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.IBoardService;
import com.gd.hr.vo.BoardForm;

@Controller
// @SessionAttributes("x") -> HttpSession session 대신 사용
public class BoardController {
	@Autowired IBoardService boardService;
	// 어디에 저장해야 할까?
	// session에 저장하고 싶으면 매개변수로 HttpSession session을 넣어줌 -> 제일 많이 씀
	// requset에 저장하고 싶으면 매개변수로 HttpRequset requset를 넣어줌
	
	// Form
	@GetMapping("/addBoard")
	public String addBoard(Model model) {
		return "addBoard";
	}
	
	// Action
	@PostMapping("/addBoard") // Multipart는 post만 가능 Get: X
	public String addBoard(Model model, BoardForm boardForm, HttpSession session) {
		// 경로 구하기
		String path = session.getServletContext().getRealPath("/upload");
		// 디버깅
		System.out.println("path : " + path);
		// requset.getServletContext().getRealPath(null);
		boardService.addBoard(boardForm, path);
		
		return "redirect:/boardList";	
	}
}
