package org.dfm.miniproject.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.minidev.json.JSONObject;


@RestController
public class MasterController {

	@Autowired
	BoardMapper boardMapper;
	
    @RequestMapping("/master/list.do")
    public ModelAndView list() throws Exception{
    	System.out.println("1111111111111111");
    	ModelAndView mav = new ModelAndView();
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList();
    	System.out.println(boardList.toString());
    	mav.addObject("list", boardList);
        return mav;
    }

    @RequestMapping("/master/delete.do")
    public void delete(@ModelAttribute BoardDTO boardDTO) throws Exception{
    	JSONObject jsonObject = new JSONObject();
    	int seq = (int) jsonObject.get("seq");
    	boardDTO.setSeq(seq);
    	boardMapper.delete(boardDTO);
    }

    @RequestMapping("/master/secret.do")
    public void secret(@ModelAttribute BoardDTO boardDTO) throws Exception{
    	JSONObject jsonObject = new JSONObject();
    	int seq = (int) jsonObject.get("seq");
    	boardDTO.setSeq(seq);
    	
    	boardDTO.setOpen_yn(setOpenYn(seq));
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
