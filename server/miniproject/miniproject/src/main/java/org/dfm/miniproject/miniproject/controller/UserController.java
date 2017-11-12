package org.dfm.miniproject.miniproject.controller;

import java.util.Arrays;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RestController
public class UserController {
	
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping(value="/user/list.do", method=RequestMethod.GET)
	public ModelAndView getUserBoardList() {
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		
		List<BoardDTO> boardList = boardMapper.getOpenBoardList();

		mav.addObject("type", "READ");
		mav.addObject("list", boardList);
		
		return mav;
	}
	
	@RequestMapping(value="/user/write.do")
	public String writePost(@ModelAttribute("BoardDTO") BoardDTO boardDto) {
		try {
			boardMapper.insertBoard(boardDto);
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect://localhost:8888/user/list.do";
		}
		
		return "redirect://localhost:8888/user/list.do";
	}
}
