package com.ch.mysql.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.mysql.dto.Board;
@Mapper
public interface BoardMapper {
	List<Board> list();
	int insert(Board board);
	void updateHit(int boardIdx);
	Board select(int boardIdx);

}