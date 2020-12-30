package com.cci.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cci.board.dao.BoardDao;
import com.cci.board.vo.BoardVO;

@Service
public class BoardService{

	@Resource
	private BoardDao boardDao;
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = boardDao.getBoardList();

		return boardList;
	}
	public boolean boardWrite(BoardVO vo) {		
		return boardDao.boardWrite(vo)==1? true:false;
	}
	public BoardVO getBoardDetail(int bnum) {
		return boardDao.getBoardDetail(bnum);
	}
	public boolean boardDelete(int bnum) {
		return boardDao.boardDelete(bnum)==1?true:false;
	}
    public boolean boardUpdate(BoardVO vo) {  	
        return boardDao.boardUpdate(vo)==1?true:false;
    }

}
