package org.dfm.miniproject.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController()
public class MasterController {

	@Autowired
	BoardMapper boardMapper;
	
    @RequestMapping("/list.do")
    public ModelAndView list() throws Exception{
    	
    	ModelAndView mav = new ModelAndView();
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList();
    	
    	System.out.println(boardList);
    	
    	mav.addObject("list", boardList);
        return mav;
    }
}
