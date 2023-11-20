package com.hk.board.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartRequest;


import com.hk.board.dtos.BoardDto;

import com.hk.board.mapper.BoardMapper;


import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	//글목록 조회
	public List<BoardDto> getAllList(){
		return boardMapper.getAllList();
	}

	
}





