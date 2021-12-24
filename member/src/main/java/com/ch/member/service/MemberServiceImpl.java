package com.ch.member.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.member.mapper.MemberMapper;
import com.ch.member.model.Member;
import com.ch.member.model.MemberPhoto;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper md;
	public Member select(String id) {
		return md.select(id);
	}
	public int insert(Member member) {
		return md.insert(member);
	}
	public int update(Member member) {
		return md.update(member);
	}
	public int delete(String id) {
		return md.delete(id);
	}
	public void insertPhotos(List<MemberPhoto> photos) {
		for(MemberPhoto mp : photos) {
			md.insertMp(mp);
		}
		//	md.insertPhotos(photos);	
	}
	public List<MemberPhoto> listPhoto(String id) {
		return md.listPhoto(id);
	}
}