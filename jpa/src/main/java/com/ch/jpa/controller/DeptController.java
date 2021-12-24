package com.ch.jpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jpa.model.Dept;
import com.ch.jpa.service.DeptService;
@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	@RequestMapping("/dept/deptList.do")
	public String deptList(Model model) {
		List<Dept> list = ds.list();
		model.addAttribute("list", list);
		return "/dept/deptList";
	}
//	@RequestMapping("/dept/insertDeptForm.do")
//	public String insertDeptForm() {
//		return "/dept/insertDeptForm";
//	}
//	@RequestMapping("/dept/deptInsert.do")
//	public String deptInsert(Dept dept, Model model) {
//		int result = 0;
//		Dept dept2 = ds.select(dept.getDeptno());
//		if (dept2 == null) result = ds.insert(dept);
//		else result = -1;
//		model.addAttribute("result", result);
//		return "/dept/deptInsert";
//	}
//	@RequestMapping("/dept/updateDeptForm.do")
//	public String updateDeptForm(int deptno, Model model) {
//		Dept dept = ds.select(deptno);
//		model.addAttribute("dept", dept);
//		return "/dept/updateDeptForm";
//	}
//	@RequestMapping("/dept/deptUpdate.do")
//	public String deptUpdate(Dept dept, Model model) {
//		int result = ds.update(dept);
//		model.addAttribute("result", result);
//		return "/dept/deptUpdate";
//	}
//	@RequestMapping("/dept/deleteDept.do")
//	public String deleteDept(int deptno,String dname, Model model) {
//		System.out.println("deptno = "+deptno);
//		System.out.println("dname= "+dname);
//		int result = ds.delete(deptno);
//		model.addAttribute("result", result);
//		return "/dept/deleteDept";
//	}
//	// jsp로 반환하지 않고 결과를 바로 전달
//	@RequestMapping(value = "/dept/deptnoChk.do", produces = "text/html;charset=utf-8") 
//	@ResponseBody
//	public String deptNoChk(int deptno) {
//		String msg = "";
//		Dept dept = ds.select(deptno); 
//		if (dept == null) msg = "사용 가능한 부서코드입니다";
//		else msg = "사용중이니 다른 것을 쓰시오";
//		return msg;
//	}
}