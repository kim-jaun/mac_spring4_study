package com.ch.member.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.member.model.Member;
import com.ch.member.model.MemberPhoto;
import com.ch.member.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	// 비밀번호를 암호화
	@Autowired
	private BCryptPasswordEncoder bpPass;
	@RequestMapping("joinForm.do")
	public String joinForm() {
		return "joinForm";
	}
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("joinForm2.do")
	public String joinForm2() {
		return "joinForm2";
	}
	@RequestMapping("login.do")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0;  // 암호가 다름
		Member member2 = ms.select(member.getId());
		if (member2 == null || member2.getDel().equals("y"))
			result = -1;  // 없는 id
		else { // if (member.getPassword().equals(member2.getPassword()))
			// 입력된 데이터도 암호와 시켜서 DB에 있는 암호와 비교
			if (bpPass.matches(member.getPassword(), member2.getPassword())) {
				result = 1; // 성공 id와 암호가 일치
				session.setAttribute("id", member.getId());
			}
		}
		model.addAttribute("result", result);
		return "login";
	}
	@RequestMapping("main.do")
	public String main(Member member, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null && !id.equals("")) {
			member = ms.select(id);
			model.addAttribute("member", member);
		}
		return "main";
	}
	@RequestMapping("view.do")
	public String view(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	@RequestMapping("view2.do")
	public String view2(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		List<MemberPhoto> list = ms.listPhoto(id);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		return "view2";
	}
	@RequestMapping("updateForm.do")
	public String updateForm(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}
	@RequestMapping("update.do")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		String fileName = member.getFile().getOriginalFilename();
		if (fileName!=null && !fileName.equals("")) {
			member.setFileName(fileName);
			String real="src/main/resources/static/images";
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
		}
		String password = bpPass.encode(member.getPassword());
		member.setPassword(password);
		result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}
	@RequestMapping("delete.do")
	public String delete(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0) session.invalidate();
		model.addAttribute("result", result);
		return "delete";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
//	@RequestMapping("idChk")
//	public String idChk(String id, Model model) {
//		String msg = "";
//		Member member = ms.select(id);
//		if (member == null) msg = "사용가능한 아이디 입니다";
//		else msg = "이미 사용중이니 다른 아이디를 쓰세요";
//		model.addAttribute("msg", msg);
//		return "idChk";
//	}
//	 produces = "text/html;charset=utf-8")을 사용하지 않으면 한글이 깨질 수 있음
	@RequestMapping(value = "idChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody  // jsp로 가지말고 바로 바디에 전달
	public String idChk(String id, Model model) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null) msg = "쭈아 그 아이디 써";
		else msg = "딴거 써 사용중...";
		return msg;
	}
	@RequestMapping("join.do")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// 화면에서 입력한 데이터가 있는지 확인 member 화면에서 입력한 데이터, member2 DB에서 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
		//	Date date = new Date();
		//	long fileName1 = date.getTime();
		//	fileName = fileName1+fileName.substring(fileName.lastIndexOf("."));
			String real="src/main/resources/static/images";
			FileOutputStream fos=new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			// 암호화
			String password = bpPass.encode(member.getPassword());
			// System.out.println("password = "+password);
			member.setPassword(password);
			member.setFileName(fileName);
			result = ms.insert(member);
		} else result = -1; // 이미 있으니 입력 불가
		model.addAttribute("result", result);
		return "join";
	}
	@RequestMapping("join2.do")
	public String join2(Member member, Model model, HttpSession session,
			MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		// 화면에서 입력한 데이터가 있는지 확인 member 화면에서 입력한 데이터, member2 DB에서 읽은 데이터
		Member member2 = ms.select(member.getId());
		String real="src/main/resources/static/images";
		if (member2 == null) {
			// 여러개의 파일을 한번에 받아온다
			List<MultipartFile> list = mhr.getFiles("file");
			// 파일 여러개를 저장할 list만들고 MemberPhoto를 생성해서 하나씩 저장
			List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
			// list의 사진을 한장씩 뽑아서 photos에 저장
			for(MultipartFile mf : list) {
				MemberPhoto mp = new MemberPhoto();
				String fileName = mf.getOriginalFilename();
				mp.setFileName(fileName);
				mp.setId(member.getId());
				photos.add(mp);
				// 파일 업로드
				FileOutputStream fos = 
						new FileOutputStream(new File(real+"/"+fileName));
				fos.write(mf.getBytes());
				fos.close();
				member.setFileName(fileName); // member 마지막 사진 추가
			}
			String password = bpPass.encode(member.getPassword());
			member.setPassword(password);
			result = ms.insert(member);
			if (result > 0) ms.insertPhotos(photos);
		} else result = -1; // 이미 있으니 입력 불가
		model.addAttribute("result", result);
		return "join";
	}
}