package com.ch.menu.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ch.menu.model.Emp;
@Mapper
public interface EmpMapper {
	List<Emp> list(int deptno);
	Emp select(int empno);
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> allList();

}