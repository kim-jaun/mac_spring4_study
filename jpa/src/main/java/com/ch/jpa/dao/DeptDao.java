package com.ch.jpa.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ch.jpa.model.Dept;
@Repository
public interface DeptDao extends JpaRepository<Dept, Object>{
	@Query("select d from Dept d order by d.deptno")
	List<Dept> list();
	
}