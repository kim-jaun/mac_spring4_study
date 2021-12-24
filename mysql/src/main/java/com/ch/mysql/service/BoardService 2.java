package com.ch.mysql.service;
import java.util.List;
import com.ch.mysql.dto.Board;
public interface BoardService {
	List<Board> list();
	int insert(Board board);
	void updateHit(int boardIdx);
	Board select(int boardIdx);

}