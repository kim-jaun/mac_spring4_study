package com.ch.jpa.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jpa.model.Dept;
import com.ch.jpa.model.Emp;
import com.ch.jpa.service.DeptService;
import com.ch.jpa.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;
//	@RequestMapping("/emp/empList.do")
//	public String empList(int deptno, Model model) {
//		Dept dept = ds.select(deptno);
//		List<Emp> empList = es.list(deptno);
//		model.addAttribute("dept", dept);
//		model.addAttribute("empList", empList);
//		return "/emp/empList";
//	}
//	@RequestMapping(value = "/emp/empnoChk.do", produces = "text/html;charset=utf-8")
//	@ResponseBody
//	public String empnoChk(int empno) {
//		String data = "";
//		Emp emp = es.select(empno);
//		if (emp == null) data = "사용 가능한 사번입니다";
//		else data = "사용중이니 다른 사번을 입력하시오";
//		return data;
//	}
//	@RequestMapping("/emp/empInsertForm.do")
//	public String empInsertForm(int deptno, Model model) {
//		List<Dept> deptList = ds.list();  // 부서코드를 선택
//		List<Emp> empList = es.list(0); // 관리자를 선택하기 위해
//		model.addAttribute("deptList", deptList);
//		model.addAttribute("empList", empList);
//		model.addAttribute("deptno", deptno);
//		return "/emp/empInsertForm";
//	}
//	@RequestMapping("/emp/empInsert.do")
//	public String empInsert(Emp emp, Model model) {
//		int result = 0;  // 입력 실패
//		Emp emp2 = es.select(emp.getEmpno());
//		if (emp2 == null) result = es.insert(emp); // 성공한 갯수
//		else result = -1; // 이미 있는 데이터
//		model.addAttribute("result", result);
//		model.addAttribute("emp", emp);
//		return "/emp/empInsert";
//	}
//	@RequestMapping("/emp/empUpdateForm.do")
//	public String empUpdateForm(int empno, Model model) {
//		Emp emp = es.select(empno);
//		List<Dept> deptList = ds.list();  // 부서코드를 선택
//		List<Emp> empList = es.list(0); // 관리자를 선택하기 위해
//		model.addAttribute("deptList", deptList);
//		model.addAttribute("empList", empList);
//		model.addAttribute("emp", emp);
//		return "/emp/empUpdateForm";
//	}
//	@RequestMapping("/emp/empUpdate.do")
//	public String empUpdate(Emp emp, Model model) {
//		int result = es.update(emp);
//		model.addAttribute("result", result);
//		model.addAttribute("emp", emp);
//		return "/emp/empUpdate";
//	}
//	@RequestMapping("/emp/empDelete.do")
//	public String empDelete(int empno, Model model) {
//		Emp emp = es.select(empno);
//		int result = es.delete(empno);
//		model.addAttribute("result", result);
//		model.addAttribute("emp", emp);
//		return "/emp/empDelete";
//	}
//	@RequestMapping("/emp/empAllList.do")
//	public String allEmpList(Model model) {
//		List<Emp> list = es.allList();
//		model.addAttribute("list", list);
//		return "emp/allEmpList";
//	}
//	@RequestMapping("/emp/empSelect.do")
//	public String empSelect(int empno, Model model) {
//		Emp emp = es.select(empno);
//		model.addAttribute("emp", emp);
//		return "/emp/empSelect";
//	}
}