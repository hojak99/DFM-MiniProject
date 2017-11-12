package org.dfm.miniproject.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.minidev.json.JSONObject;

@RestController
public class MasterController {

	@Autowired
	BoardMapper boardMapper;
	
   
    @RequestMapping(value = "/master/list.do", method=RequestMethod.GET)
    public ModelAndView list(@ModelAttribute BoardDTO boardDTO) throws Exception{
    	//JSONObject jsonobj = new JSONObject();
    	ModelAndView mav = new ModelAndView();
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList();
    	
    	System.out.println(boardList);
    	
    	mav.addObject("list", boardList);
        return mav;
    }

    @RequestMapping("/master/delete.do")
    public void delete(@RequestBody BoardDTO boardDTO) throws Exception{
    	boardMapper.delete(boardDTO);
    }

    @RequestMapping("/master/secret.do")
    public void secret(@RequestBody BoardDTO boardDTO) throws Exception{
    	boardDTO.setOpen_yn(setOpenYn(boardDTO.getSeq()));
    	boardMapper.secret(boardDTO);
    }

    public String setOpenYn(int seq){
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setSeq(seq);
    	BoardDTO boardOpenYN = boardMapper.getBoard(boardDTO);
    	
    	String boardOpenYNVal = boardOpenYN.getOpen_yn();
    	if (boardOpenYNVal.equals("Y")){
    		boardOpenYNVal = "N";
    	}else {
    		boardOpenYNVal = "Y";
    	}
    	return boardOpenYNVal;
    }

/*    @RequestMapping("/master/search.do")
    public ModelAndView search() throws Exception{
    	ModelAndView mav = new ModelAndView();
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList();
    	mav.addObject("list", boardList);
        return mav;
    }*/
}
