package org.dfm.miniproject.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.dfm.miniproject.miniproject.dto.BoardDTO;
import org.dfm.miniproject.miniproject.mapper.BoardMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@RestController
public class MasterController {

	@Autowired
	BoardMapper boardMapper;

    @RequestMapping(value = "/master/list.do", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam("offset") int offset, @RequestParam("count") int count) throws Exception{
    	ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setOffset(offset);
    	boardDTO.setCount(count);
    	List<BoardDTO> boardList = new ArrayList<>();
    	boardList = boardMapper.getAllBoardList(boardDTO);
    	mav.addObject("list", boardList);
    	mav.addObject("nextOffset", boardDTO.getOffset()+boardDTO.getCount());
        return mav;
    }

    @RequestMapping("/master/delete.do")
    public ModelAndView delete(@RequestParam("seq") int seq)throws Exception{
    	ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setSeq(seq);
    	try {
    		boardMapper.delete(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	mav.addObject("result", "delete-success");
    	return mav;
    }

    @RequestMapping("/master/secret.do")
    public ModelAndView secret(@RequestParam("seq") int seq)throws Exception{
    	ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setSeq(seq);
    	boardDTO.setOpen_yn(setOpenYn(seq));
    	try {
    		boardMapper.secret(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	mav.addObject("result", "secret-success");
    	return mav;
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

    @RequestMapping(value="/master/search.do", method=RequestMethod.GET)
    public ModelAndView search(@RequestParam("offset") int offset, @RequestParam("count") int count, @RequestParam("user_id") String user_id) throws Exception{
    	ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    	List<BoardDTO> boardList = new ArrayList<>();
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setOffset(offset);
    	boardDTO.setCount(count);
    	boardDTO.setUser_id(user_id);
    	boardList = boardMapper.getAllBoardList(boardDTO);
    	mav.addObject("list", boardList);
    	mav.addObject("nextOffset", boardDTO.getOffset()+boardDTO.getCount());
        return mav;
    }
}
