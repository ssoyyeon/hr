package com.gd.hr.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardForm {
	// Board board, List<MultipartFile> multiList를 입력 받아야 함.
	private Board board; // <input name="board,boardNo">
	private List<MultipartFile> multiList;
}
