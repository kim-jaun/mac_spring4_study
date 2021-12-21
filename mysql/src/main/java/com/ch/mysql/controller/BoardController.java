package com.ch.mysql.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mysql.dto.Board;
import com.ch.mysql.service.BoardService;
@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	@RequestMapping("/board/boardList.do") // 확장자 포함
	public String boardList(Model model) {
		List<Board> list = bs.list();
		model.addAttribute("list", list);
		return "/board/boardList";
	}
	@RequestMapping("/board/boardWriteForm.do")
	public String insertForm() {
		return "/board/boardWriteForm";
	}
	@RequestMapping("/board/insertBoard.do")
	public String insert(Board board, Model model) {
		int result = bs.insert(board);
		model.addAttribute("result", result);
		return "/board/insertBoard";
	}
	@RequestMapping("/board/boardDetail.do")
	public String detail(int boardIdx, Model model) {
		bs.updateHit(boardIdx);
		Board board = bs.select(boardIdx);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
}