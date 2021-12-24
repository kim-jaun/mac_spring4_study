package com.ch.jpa.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jpa.dao.EmpDao;
import com.ch.jpa.model.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
//	public List<Emp> list(int deptno) {
//		return ed.list(deptno);
//	}
//	public Emp select(int empno) {
//		return ed.select(empno);
//	}
//	public int insert(Emp emp) {
//		return ed.insert(emp);
//	}
//	public int update(Emp emp) {
//		return ed.update(emp);
//	}
//	public int delete(int empno) {
//		return ed.delete(empno);
//	}
////	public List<Emp> allList() {
//		return ed.allList();
//	}
}