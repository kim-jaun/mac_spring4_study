package com.ch.oracle.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.oracle.model.Emp;
@Mapper
public interface EmpMapper {
	List<Emp> list(int deptno);
	Emp select(int empno);
	List<Emp> empList();
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> allList();

}