package com.gd.hr.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.hr.mapper.BoardMapper;
import com.gd.hr.mapper.BoardfileMapper;
import com.gd.hr.vo.BoardForm;
import com.gd.hr.vo.Boardfile;

@Service // 리턴값을 분석하여 클라이언트에게 전송
@Transactional
public class BoardService implements IBoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	@Override
	public void addBoard(BoardForm boardForm, String path) {
		// 디버깅
		System.out.println(boardForm.getBoard());  // board.getBoardNo()  -> 0
		int row = boardMapper.insertBoard(boardForm.getBoard());
		// 디버깅
		System.out.println(boardForm.getBoard());  // board.getBoardNo()  -> selectkey
		System.out.println("row : " + row);
		
		if(row == 1 & boardForm.getMultiList() != null) {
			for(MultipartFile mf : boardForm.getMultiList()){
				
				// 매번 새로운 Boardfile을 만들어야 함
				Boardfile boardfile = new  Boardfile();
				boardfileMapper.insertBoardfile(boardfile);
				
				// 중복되지 않는 랜덤이름 생성 UUID API를 사용
				String filename = UUID.randomUUID().toString().replace("-", "");
				boardfile.setFilename(filename);
				boardfile.setFileType(mf.getContentType());
				boardfile.setOriginName(mf.getOriginalFilename());
				boardfile.setFileSize(mf.getSize());
				// insertBoardfile메서드 호출하고 안에 매개변수 boardfile값 넣어주기
				boardfileMapper.insertBoardfile(boardfile);
				// 디버깅
				System.out.println("boardfile : " + boardfile);

				// 파일 확장자 - mf.getOriginalFilename()에서 인덱스를 자르면 됨
				// mf.getOriginalFilename().lastIndexOf(".")로 마지막 점을 찾음
				// substring()로 .txt를 찾음
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
				// 디버깅
				System.out.println("ext : " + ext);

				// 파일 생성 - MultipartFile 안에 파일 생성 API(transferTo)가 있음
				// transferTo 리턴타입을 주기 위해 new File()파일 객체 생성
				try {
					// c://upload/ttt.txt
					// 새로운 bean 파일 안에 MultipartFile안에 파일을 하나씩 복사
					mf.transferTo(new File(path + filename + ext));
				} catch (Exception e) {
					e.printStackTrace();
					// @Transactional 처리가 되도록 강제로 RuntimeException(try절을 발생시키지 않는) 발생
					throw new RuntimeException();
				}
			}
		}
	}

}
