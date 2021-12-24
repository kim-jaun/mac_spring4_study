package com.ch.member.service;
import java.util.List;

import com.ch.member.model.Member;
import com.ch.member.model.MemberPhoto;
public interface MemberService {
	Member select(String id);
	int insert(Member member);
	int update(Member member);
	int delete(String id);
	void insertPhotos(List<MemberPhoto> photos);
	List<MemberPhoto> listPhoto(String id);

}