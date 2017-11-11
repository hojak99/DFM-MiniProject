package org.dfm.miniproject.miniproject.mapper;

import java.util.List;

import org.dfm.miniproject.miniproject.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> getAllBoardList();
	public List<BoardDTO> getOpenBoardList();
	public void insertBoard(BoardDTO boardDto);
}
