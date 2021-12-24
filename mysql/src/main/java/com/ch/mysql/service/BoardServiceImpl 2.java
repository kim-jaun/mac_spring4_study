package com.ch.mysql.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.mysql.dto.Board;
import com.ch.mysql.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bm;
	public List<Board> list() {
		return bm.list();
	}
	public int insert(Board board) {
		return bm.insert(board);
	}
	public void updateHit(int boardIdx) {
		bm.updateHit(boardIdx);
	}
	public Board select(int boardIdx) {
		return bm.select(boardIdx);
	}
}