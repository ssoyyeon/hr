package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Board;

@Mapper
public interface BoardMapper {
	
	// board insert C 추가 
	int insertBoard(Board board);

	// board select R 읽기 
	 List<Map<String,Object>> selectBoardList();

	// board update U 수정

	// board delete D 삭제
}
