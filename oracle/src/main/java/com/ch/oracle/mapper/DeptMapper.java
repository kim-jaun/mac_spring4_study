package com.ch.oracle.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.oracle.model.Dept;
@Mapper
public interface DeptMapper {
	List<Dept> list();
	Dept select(int deptno);
	int insert(Dept dept);
	int update(Dept dept);
	int delete(int deptno);
}