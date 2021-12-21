package com.ch.oracle.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.oracle.mapper.DeptMapper;
import com.ch.oracle.model.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper dd;
	public List<Dept> list() {
		return dd.list();
	}
	public Dept select(int deptno) {
		return dd.select(deptno);
	}
	public int insert(Dept dept) {
		return dd.insert(dept);
	}
	public int update(Dept dept) {
		return dd.update(dept);
	}
	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}