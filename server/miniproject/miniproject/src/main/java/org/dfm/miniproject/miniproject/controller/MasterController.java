package org.dfm.miniproject.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class MasterController {

	@Autowired
	BoardMapper boardMapper;
	
    @RequestMapping(value = "/master/list.do")
    public String list(@ModelAttribute BoardDTO boardDTO) throws Exception{
    	JSONObject jsonobj = new JSONObject();
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList(boardDTO);
    	jsonobj.put("list", boardList);
    	jsonobj.put("nextOffset", boardDTO.getOffset()+boardDTO.getCount());
        return jsonobj.toString();
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
