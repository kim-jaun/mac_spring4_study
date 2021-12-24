package com.ch.menu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.menu.mapper.EmpMapper;
import com.ch.menu.model.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper ed;
	public List<Emp> list(int deptno) {
		return ed.list(deptno);
	}
	public Emp select(int empno) {
		return ed.select(empno);
	}
	public int insert(Emp emp) {
		return ed.insert(emp);
	}
	public int update(Emp emp) {
		return ed.update(emp);
	}
	public int delete(int empno) {
		return ed.delete(empno);
	}
	public List<Emp> allList() {
		return ed.allList();
	}
}