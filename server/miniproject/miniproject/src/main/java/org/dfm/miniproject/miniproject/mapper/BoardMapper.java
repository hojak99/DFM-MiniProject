package org.dfm.miniproject.miniproject.mapper;

import java.util.List;
import java.util.Map;

import org.dfm.miniproject.miniproject.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> getAllBoardList(BoardDTO boardDTO);
	public BoardDTO getBoard(BoardDTO boardDTO);
	public void delete(BoardDTO boardDTO);
	public void secret(BoardDTO boardDTO);
	
	public List<BoardDTO> getOpenBoardList(Map<String, Integer> map);
	public void insertBoard(BoardDTO boardDto);
}
