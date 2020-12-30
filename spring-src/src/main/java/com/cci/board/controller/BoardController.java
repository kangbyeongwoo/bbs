package com.cci.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cci.board.service.BoardService;
import com.cci.board.vo.BoardVO;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	//게시판 리스트
	@GetMapping("/BoardList")
	public List<BoardVO> getBoardList(Model model) {
		List<BoardVO> boardList=boardService.getBoardList();
		model.addAttribute("boardList",boardList);
		System.out.println(boardList);		
		return boardList;
	}
	
	//게시판 글쓰기기
	@PostMapping("/BoardWrite")
	public void BoardWritePost(@RequestBody BoardVO vo) {
		System.out.println("write bnum = "+vo.getBnum());
		System.out.println("write date = "+vo.getBdate());
		System.out.println("write btitle"+vo.getBtitle());
		
		boardService.boardWrite(vo);
	}
	
	//게시판 상세보기
	@GetMapping("/BoardDetail/{bnum}")
	public BoardVO BoardDetail(@PathVariable int bnum) {
		System.out.println(bnum);
		System.out.println(boardService.getBoardDetail(bnum));		
		return boardService.getBoardDetail(bnum);
	}
	
	//상세보기에서 수정하기로 데이타 옴기기.
    @GetMapping("/BoardModify/{bnum}")
    private BoardVO boardUpdateForm(@PathVariable int bnum, Model model) {        
		System.out.println(bnum);
		System.out.println(boardService.getBoardDetail(bnum));		
        return boardService.getBoardDetail(bnum);
    }  
    
    //게시판 수정하기
    @PostMapping("/BoardModify/{bnum}")
    private void boardUpdatePost(@RequestBody BoardVO vo) {    	
        System.out.println(vo.getBtitle());
        System.out.println(vo.getBcontent());
        System.out.println(vo.getBwriter());
        System.out.println(vo.getBnum());     
        
        boardService.boardUpdate(vo);
    }    	
	
	//게시판 삭제
	@PostMapping("/BoardDetail/{bnum}")
	public String BoardDeletePost(@PathVariable int bnum) {
		System.out.println("delete bnum : "+bnum);
		boardService.boardDelete(bnum);
		return "완료";
	}
}
