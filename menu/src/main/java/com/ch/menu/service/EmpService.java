package com.ch.menu.service;
import java.util.List;

import com.ch.menu.model.Emp;
public interface EmpService {
	List<Emp> list(int deptno);
	Emp select(int empno);
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> allList();

}