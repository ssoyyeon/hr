package com.gd.hr.service;


import org.springframework.stereotype.Service;
import com.gd.hr.vo.BoardForm;


@Service
public interface IBoardService {

	// board insert C 추가 	
	void addBoard(BoardForm boardForm, String path);

	// board select R 읽기 

	// board update U 수정

	// board delete D 삭제
	
}
