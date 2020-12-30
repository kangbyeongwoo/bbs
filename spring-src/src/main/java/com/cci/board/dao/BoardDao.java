package com.cci.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cci.board.vo.BoardVO;

@Mapper
public interface BoardDao {
	public List<BoardVO> getBoardList();
	
	public int boardWrite(BoardVO vo);
	
	public BoardVO getBoardDetail(int bnum);
	
	public int boardDelete(int bnum);
	
	public int boardUpdate(BoardVO vo);
}
