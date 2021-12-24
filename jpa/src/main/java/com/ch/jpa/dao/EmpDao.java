package com.ch.jpa.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ch.jpa.model.Emp;
@Repository
public interface EmpDao extends JpaRepository<Emp, Object> {

//	List<Emp> list(int deptno);
//
//	Emp select(int empno);
//
//	int insert(Emp emp);
//
//	int update(Emp emp);

//  List<Emp> allList();
//	int delete(int empno);
	

}