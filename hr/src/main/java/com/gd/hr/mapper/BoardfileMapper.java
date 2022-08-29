package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Boardfile;

@Mapper
public interface BoardfileMapper {
	
	// boardfile insert C 추가 
	int insertBoardfile(Boardfile boardfile);

	// boardfile select R 읽기 

	// boardfile update U 수정

	// boardfile delete D 삭제
}
