package org.dfm.miniproject.miniproject.controller;

import java.util.Arrays;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jayway.jsonpath.internal.path.ArraySliceOperation;

@RestController
public class UserController {
	
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping(value="/user/list.do")
	public String getUserBoardList() {
		ModelAndView mav = new ModelAndView();
		
		List<BoardDTO> boardList = boardMapper.getOpenBoardList();
		System.out.println(boardList.toArray());
		
		mav.setViewName("list");
		mav.addObject("type", "READ");
		mav.addObject("list", boardList.toString());
		
		return mav.toString();
	}
	
	@RequestMapping(value="/user/write.do")
	public String writePost(@ModelAttribute BoardDTO boardDto) {
		ModelAndView mav = new ModelAndView();
		
		try {
			BoardDTO temp = new BoardDTO();
			temp.setContent("insert~~~");
			temp.setTitle("odw?");
			temp.setUser_id("tootoo");
			boardMapper.insertBoard(temp);
		}catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
		mav.addObject("list", boardMapper.getOpenBoardList());
		return mav.toString();
	}
}
